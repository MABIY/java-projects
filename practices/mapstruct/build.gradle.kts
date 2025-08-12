// tag::app_dependencies[]
plugins {
    id("buildlogic.java-library-conventions")
}

dependencies{
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
}

// end::app_dependencies[]

group = "com.lh.java-base"
version = libs.versions.project.version.get()
