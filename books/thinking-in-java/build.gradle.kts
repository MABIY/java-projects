// tag::app_dependencies[]
plugins {
    id("buildlogic.java-library-conventions")
}


// end::app_dependencies[]

group = "com.lh.think-in-java"
version = libs.versions.project.version.get()

repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }

    mavenCentral()
}