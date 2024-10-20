package com.lh.commons.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.auto.service.AutoService;
import com.lh.commons.annotation.AutoValueDTO;
import com.lh.commons.annotationprocessor.base.BaseProcessor;
import com.lh.commons.annotationprocessor.utils.StringUtils;
import com.squareup.javapoet.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.TypeMirror;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lh.commons.annotationprocessor.utils.StringUtils.uppercaseFirstLetter;


@AutoService(Processor.class)
public class AutoValueProcessor extends BaseProcessor {
    private static void extracted(MethodSpec.Builder createMethodBuilder, FieldSpec fieldSpec) {
        createMethodBuilder.addStatement(
                "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
    }

    private FieldSpec convert(TypeElementField typeElementField) {
        VariableElement variableElement = typeElementField.variableElement;
        TypeName typeName = typeElementField.fieldGenericParameter.orElse(TypeName.get(variableElement.asType()));
        return FieldSpec.builder(
                        typeName,
                        variableElement.getSimpleName().toString(),
                        variableElement.getModifiers().toArray(Modifier[]::new))
                .addAnnotations(copyAnnotations(variableElement))
                .build();
    }

    @Override
    protected void process(Element element, RoundEnvironment roundEnv) {
        TypeElement typeElement = (TypeElement) element;

        //原始待处理类的泛化参数
        List<TypeVariableName> typeVariableNamesOfOrgianTypeElement = typeElement.getTypeParameters().stream()
                .map(typeParameterElement -> (TypeVariableName) TypeVariableName.get(typeParameterElement.asType()))
                .toList();

        List<AnnotationSpec> classAnnotations = copyAnnotations(typeElement);
        Stream<Map.Entry<TypeElement, Stream<Element>>> inheritedChain = inheritedChain(typeElement.asType());

        Map<String, List<GeneratedField>> generatedFieldsMap = inheritedChain
                .flatMap(typeElementStreamEntry -> typeElementStreamEntry
                        .getValue()
                        .filter(value -> value.getKind().isField())
                        .map(filed -> (VariableElement) filed)
                        .map(field -> {
                            TypeElement enclosedFieldTypeElement = typeElementStreamEntry.getKey();
                            return getTypeElementField(field, typeElement, enclosedFieldTypeElement);
                        }))
                .flatMap(typeElementField -> getDtoAnnotationValueType(typeElementField.variableElement).stream()
                        .map(mirror -> new GeneratedField(mirror, typeElementField)))
                .collect(Collectors.groupingBy(GeneratedField::getGroupName));

        Map<String, List<GeneratedField>> classAndAllGenertedFieldsMap = generatedFieldsMap.keySet().stream()
                .flatMap(groupName -> generatedFieldsMap.get(groupName).stream()
                        .findFirst()
                        .map(generatedField -> inheritedChain(generatedField.group)
                                .flatMap(typeElementStreamEntry ->
                                        Optional.ofNullable(generatedFieldsMap.get(typeElementStreamEntry
                                                        .getKey()
                                                        .toString()))
                                                .stream()
                                                .flatMap(Collection::stream)
                                                .map(generatedField1 -> new GeneratedField(
                                                        generatedField.group, generatedField1.field))))
                        .orElse(Stream.empty()))
                .collect(Collectors.groupingBy(
                        generatedField -> typeElement.getEnclosingElement() + ".value." + typeElement.getSimpleName()
                                + StringUtils.getLastDelimiterValue(generatedField.getGroupName(), '.')));
        for (String classQualifedNameString : classAndAllGenertedFieldsMap.keySet()) {
            ClassName classQualifiedName = ClassName.bestGuess(classQualifedNameString);
            createJavaFile(
                    classQualifiedName.packageName(),
                    classQualifiedName.simpleName(),
                    typeVariableNamesOfOrgianTypeElement,
                    classAnnotations,
                    classAndAllGenertedFieldsMap.get(classQualifedNameString));
        }
    }

    private TypeElementField getTypeElementField(
            VariableElement field, TypeElement orgianTypeElement, TypeElement enclosedFieldTypeElement) {
        ClassName fieldGenericParameter = null;
        if (TypeName.get(field.asType()) instanceof TypeVariableName aField) {
            if (types.asElement(orgianTypeElement.getSuperclass()).asType() == enclosedFieldTypeElement.asType()) {
                if (TypeName.get(orgianTypeElement.getSuperclass()) instanceof ParameterizedTypeName) { // 判断是否是类型化参数
                    List<TypeName> typeArguments =
                            ((ParameterizedTypeName) TypeName.get(enclosedFieldTypeElement.asType())).typeArguments;
                    for (int i = 0; i < typeArguments.size(); i++) {
                        if (aField.toString().equals(typeArguments.get(i).toString())) {
                            Object object = ((ParameterizedTypeName) TypeName.get(orgianTypeElement.getSuperclass()))
                                    .typeArguments.get(i);
                            if (object instanceof ClassName item) {
                                fieldGenericParameter = item;
                                break;
                            }
                        }
                    }
                }
            }
        }
        types.asElement(orgianTypeElement.getSuperclass());
        return new TypeElementField(fieldGenericParameter, enclosedFieldTypeElement, field);
    }

    private List<AnnotationSpec> copyAnnotations(Element element) {
        return elements.getAllAnnotationMirrors(element).stream()
                .map(AnnotationSpec::get)
                .filter(annotationSpec -> {
                    String canonicalClassName = annotationSpec.type.toString();
                    return !canonicalClassName.startsWith("javax.persistence.")
                            && !canonicalClassName.startsWith("lombok.")
                            && !canonicalClassName.startsWith("com.lh.annotation.")
                            && !canonicalClassName.startsWith("jakarta.persistence.")
                            && !canonicalClassName.startsWith("com.yunmo.generator.annotation.")
                            && !canonicalClassName.startsWith("org.hibernate.annotations.")
                            && !canonicalClassName.startsWith("com.fasterxml.jackson.annotation.JsonView");
                })
                .toList();
    }

    private void createJavaFile(
            String packageName,
            String classSimpleName,
            List<TypeVariableName> typeVariableNames,
            List<AnnotationSpec> classAnnotationSpecs,
            List<GeneratedField> generatedFields) {
        ClassName className = ClassName.get(packageName, classSimpleName);
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(classSimpleName)
                .addAnnotation(Data.class)
                .addTypeVariables(typeVariableNames)
                .addAnnotations(classAnnotationSpecs)
                .addModifiers(Modifier.PUBLIC);

        Set<FieldSpec> fieldSpecs =
                generatedFields.stream().map(field -> convert(field.field)).collect(Collectors.toSet());

        fieldSpecs.forEach(classBuilder::addField);

        MethodSpec.Builder createMethodBuilder = MethodSpec.methodBuilder("create")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addStatement("$T entity = new $T()", className, className);
        for (FieldSpec fieldSpec : fieldSpecs) {
            extracted(createMethodBuilder, fieldSpec);
        }
        createMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(createMethodBuilder.build());

        MethodSpec.Builder assignMethodBuilder = MethodSpec.methodBuilder("assign")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addParameter(className, "entity");
        for (FieldSpec fieldSpec : fieldSpecs) {
            assignMethodBuilder.addStatement(
                    "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
        }
        assignMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(assignMethodBuilder.build());

        MethodSpec.Builder patchMethodBuilder = MethodSpec.methodBuilder("patch")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addParameter(className, "entity");
        for (FieldSpec fieldSpec : fieldSpecs) {
            if (fieldSpec.type.isPrimitive()) {
                patchMethodBuilder.addStatement(
                        "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
            } else {
                patchMethodBuilder.beginControlFlow("if (" + fieldSpec.name + " != null )");
                patchMethodBuilder.addStatement(
                        "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
                patchMethodBuilder.endControlFlow();
            }
        }
        patchMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(patchMethodBuilder.build());
        JavaFile javaFile = JavaFile.builder(packageName, classBuilder.build()).build();
        writeJavaFile(packageName, classSimpleName, javaFile);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(AutoValueDTO.class.getCanonicalName());
    }

    private Stream<Map.Entry<TypeElement, Stream<Element>>> inheritedChain(TypeMirror typeMirror) {
        if (typeMirror.toString().equals(Object.class.getCanonicalName())) {
            return Stream.empty();
        }
        Stream<Map.Entry<TypeElement, Stream<Element>>> superClassStream =
                types.directSupertypes(typeMirror).stream().flatMap(this::inheritedChain);
        Stream<Map.Entry<TypeElement, Stream<Element>>> typeVariableMapStream = Stream.of(new AbstractMap.SimpleEntry<>(
                (TypeElement) types.asElement(typeMirror),
                types.asElement(typeMirror).getEnclosedElements().stream().map(element -> element)));
        return Stream.concat(typeVariableMapStream, superClassStream);
    }

    private List<? extends TypeMirror> getDtoAnnotationValueType(VariableElement variableElement) {
        try {
            JsonView jsonView = variableElement.getAnnotation(JsonView.class);
            if (jsonView != null) {
                jsonView.value();
            } else {
                return List.of();
            }
            throw new RuntimeException("parse dto annotation value error"); // 测试错误是的单元和现象
        } catch (MirroredTypesException ex) {
            return ex.getTypeMirrors();
        }
    }

    private static class TypeElementField {
        public final TypeElement typeElement;
        public final Optional<TypeName> fieldGenericParameter;
        public final VariableElement variableElement;

        public TypeElementField(
                TypeName fieldGenericParameter, TypeElement typeElement, VariableElement variableElement) {
            this.fieldGenericParameter = Optional.ofNullable(fieldGenericParameter);
            this.typeElement = typeElement;
            this.variableElement = variableElement;
        }
    }

    @AllArgsConstructor
    private static class GeneratedField {
        public TypeMirror group;
        public TypeElementField field;

        public String getGroupName() {
            return group.toString();
        }
    }
}