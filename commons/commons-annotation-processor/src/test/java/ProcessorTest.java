import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import com.lh.commons.annotationprocessor.AutoValueProcessor;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.is;
import static com.google.testing.compile.CompilationSubject.assertThat;


/**
 * @author liu.hua
 */
class ProcessorTest {
    Compiler compiler;


    @BeforeEach
    public void setupCompiler() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> lombokAnnotationProcessor =
                getClass().getClassLoader().loadClass("lombok.launch.AnnotationProcessorHider$AnnotationProcessor");
        Class<?> lombokClaimingProcessor =
                getClass().getClassLoader().loadClass("lombok.launch.AnnotationProcessorHider$ClaimingProcessor");

        compiler = Compiler.javac()
                .withProcessors(
                        (Processor) lombokAnnotationProcessor
                                .getDeclaredConstructor()
                                .newInstance(),
                        (Processor)
                                lombokClaimingProcessor.getDeclaredConstructor().newInstance(),
                        new AutoValueProcessor());
    }

    @Test
    @Order(1)
    void test() throws IOException {
        JavaFileObject helloWorld = JavaFileObjects.forResource("OrderedPair.java");
        Compilation compilation = compiler.compile(helloWorld);
        assertThat(compilation).succeeded();

        checkResult(compilation,"com.lh.commons.annotationprocessor.value.OrderedPairNew","result/generic/OrderedPairNew.java");
    }


    private static void checkResult(Compilation compilation,String generatedSourceFileName,String resourceName) throws IOException {
        String actualImpl = compilation.generatedSourceFile(generatedSourceFileName)
                .orElseThrow()
                .getCharContent(false)
                .toString();

        JavaFileObject resultJavaFileObject = JavaFileObjects.forResource(resourceName);
        String result = resultJavaFileObject.getCharContent(false).toString();
        MatcherAssert.assertThat(actualImpl.lines().toArray(), is(result.lines().toArray()));
    }
}

