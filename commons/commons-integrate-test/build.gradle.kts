plugins {
    id("buildlogic.java-common-conventions")
}

group="com.lh.commons"

dependencies{
    annotationProcessor(project(":commons-annotation-processor"))
    compileOnly(project(":commons-annotation"))
}
