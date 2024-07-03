@file:Suppress("UnstableApiUsage")

plugins {
//    id("java-library")
    id("my-java-library")
}

// java { } clause is an extension from the
// "java", "java-library" and "application" plugins.
//
// We don't need to apply for each build.gradle.kts
// when using `custom` plugin named "my-java-library"

//java{
//
//    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
//
//}

dependencies {
    implementation(dependencyNotation = project(":data-model"))
    // coordinate notation : (group : name : version) 
    implementation(dependencyNotation = "org.apache.commons:commons-lang3:3.12.0")
//    api(dependencyNotation = "org.apache.commons:commons-lang3:3.12.0")  // <- if you wish to expose all classes and references to upper level (app module)
    implementation("org.slf4j:slf4j-api:1.7.36")

//    api("") // <-- dependency is transitively visible as compilatio (java-library only)
//    runtimeOnly("") // <-- only at runtime
//    compileOnly("group:name") // <-- only at compile time
}

configurations {
    compileClasspath // <- compile time "view" (aka "variation")
    runtimeClasspath // <- runtime "view" (aka "variation")

}