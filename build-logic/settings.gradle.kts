dependencyResolutionManagement {
    // Reuse version catalog from the main build.
    versionCatalogs {
        create("libs", { from(files("../gradle/libs.versions.toml")) })
    }
}

//todo_lh share ../gradle/libs.versions.toml config


rootProject.name = "build-logic"

