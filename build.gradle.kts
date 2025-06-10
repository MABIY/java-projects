plugins {
    id("buildlogic.java-library-conventions")
}


// end::app_dependencies[]

group = "com.lh.java-projects"
version = libs.versions.project.version.get()

repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }

    mavenCentral()
}

dependencies {
    implementation("com.lh.think-in-java:thinking-in-java")
}
