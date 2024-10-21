plugins {
    id("buildlogic.java-library-conventions")
    id("maven-publish")
}


publishing {
    repositories {
        maven {
            val releasesRepoUrl = uri("")
            val snapshotsRepoUrl = uri("")
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}


dependencies{
    implementation(project(":commons-annotation"))
    implementation("com.squareup:javapoet:1.13.0")

    implementation("com.google.auto.service:auto-service-annotations:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")

    testImplementation("org.projectlombok:lombok:1.18.34")
    testImplementation("com.google.testing.compile:compile-testing:0.21.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
}