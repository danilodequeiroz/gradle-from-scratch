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
    // coordinate notation : (group : name : version)
    implementation(platform("com.github.danilodequeiroz:platform"))
    implementation(dependencyNotation = project(":data-model"))

    /**
     *  api(dependencyNotation = "org.apache.commons:commons-lang3:3.12.0")
     *   - if you wish to expose all classes and references to upper level (app module)
     */
    implementation(dependencyNotation = "org.apache.commons:commons-lang3")
    implementation("org.slf4j:slf4j-api")

    testImplementation("org.junit.jupiter:junit-jupiter-api") // Section 4: Tests
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine") // Section 4: Tests

//    api("") // <-- dependency is transitively visible as compilation (java-library only)
//    runtimeOnly("") // <-- only at runtime
//    compileOnly("group:name") // <-- only at compile time
}

// Could be kept here, but we moved to gradle/platform/bbuild.gradle.kts
//dependencies.constraints {
//    implementation(constraintNotation = "org.apache.commons:commons-lang3:3.12.0")
//    implementation(constraintNotation = "org.slf4j:slf4j-api:2.0.13")
//}

//configurations {
//    compileClasspath // <- compile time "view" (aka "variation")
//    runtimeClasspath // <- runtime "view" (aka "variation")
//}