rootProject.name = "gradle-from-scratch"

pluginManagement {
    repositories.gradlePluginPortal()
//    repositories.mavenCentral()
//    repositories.google()

    /**
     * Adding custom maven repos such as internal mirrors
     */

//    repositories.maven("http://localhost/repo"){
//        credentials.username = ""
//        credentials.password = ""
//    }

    /**
    includes another repository or project from source as a component
    to be used on this project (current: gradle-from-scratch)
     **/

    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
//    repositories.google()

    /**
     * Adding custom maven repos such as internal mirrors
     */

//    repositories.maven("http://localhost/repo"){
//        credentials.username = ""
//        credentials.password = ""
//    }

    /**
     includes another repository or project from source as a component
     to be used on this project (current: gradle-from-scratch)
    **/

 //    includeBuild("../gradle-from-scratch-dependant-build")
    includeBuild("gradle/platform")
}


// app
// business-logic
// data-model

include("app")
include("business-logic")
include("data-model")


//include("app", "business-logic", "data-model")