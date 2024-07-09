plugins {
//    id("application") // already applies id("java")
    id("my-application")
}

// java { } clause is an extension from the
// "java", "java-library" and "application" plugins.
//
// We don't need to apply for each build.gradle.kts
// when using `custom` plugin named "my-application"

//java{
//
//    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
//
//}

application {
    mainClass.set("com.github.danilodequeiroz.graldefundamentals.Application")
}

dependencies {
    implementation(platform("com.github.danilodequeiroz:platform"))
    implementation(dependencyNotation = project(":business-logic"))
    implementation(dependencyNotation = project(":data-model"))
    runtimeOnly(libs.slf4j.simple)
    /** Previous method  */
//    runtimeOnly("org.slf4j:slf4j-simple")
}