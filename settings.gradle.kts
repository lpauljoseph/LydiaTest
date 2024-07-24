pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LydiaTestApplication"
include(":app")
include(":core:database")
include(":core:model")
include(":features:search:presentation")
include(":core:repository")
include(":core:datasource:remote")
include(":core:repository:impl")
include(":core:datasource:local")
include(":features:details:presentation")
