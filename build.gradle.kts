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

tasks.named("build") {
    // 对每个 included build 注册依赖
    gradle.includedBuilds.map { included ->
        dependsOn(included.task(":build"))
    }
}
