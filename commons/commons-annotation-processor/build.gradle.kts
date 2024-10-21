plugins {
    id("buildlogic.java-library-conventions")
    id("maven-publish")
}

group="com.lh.commons"


publishing {
    repositories {
        maven {
            isAllowInsecureProtocol=true
            val releasesRepoUrl = uri("http://192.168.0.109:8081/repository/maven-releases/")
            val snapshotsRepoUrl = uri("http://192.168.0.109:8081/repository/maven-snapshots/")
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials{
                username = "admin"
                password = "admin123"

            }
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