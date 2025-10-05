// tag::app_dependencies[]
plugins {
    id("buildlogic.java-library-conventions")
}

dependencies{
    implementation(fileTree("libs") { include("*.jar")})
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(10)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 8
}

// end::app_dependencies[]

group = "com.lh.head-first-design-patterns"
version = libs.versions.project.version.get()
