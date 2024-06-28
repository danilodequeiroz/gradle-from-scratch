pluginManagement {
    repositories.gradlePluginPortal()
    repositories.google()
    repositories.maven("http://localhost/repo"){
        credentials.username = ""
        credentials.password = ""
    }
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
    repositories.google()
    repositories.maven("http://localhost/repo"){
        credentials.username = ""
        credentials.password = ""
    }

    // includes another repository or project
    // to build along with the current (current: gradle-from-scratch)
    includeBuild("../gradle-from-scratch-dependant-build")
}

rootProject.name = "gradle-from-scratch"

include("app")
include("business-logic")
include("data-model")


//include("app", "business-logic", "data-model")

// app
// business-logic
// data-model
