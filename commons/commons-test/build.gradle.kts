plugins {
    id("buildlogic.java-common-conventions")
}

dependencies{
    annotationProcessor(project(":commons-annotation-processor"))
    compileOnly(project(":commons-annotation"))
}
