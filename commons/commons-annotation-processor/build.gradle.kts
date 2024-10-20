plugins {
    id("buildlogic.java-library-conventions")
}


dependencies{
    implementation(project(":commons-annotation"))
    implementation("com.squareup:javapoet:1.13.0")

    implementation("com.google.auto.service:auto-service-annotations:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
}