rootProject.name = "java-projects"

pluginManagement {
    includeBuild("build-logic")
}

includeBuild("commons")


includeBuild("practice/reactive")

include(":practice:reactive")
project(":practice:reactive").name="reactive"