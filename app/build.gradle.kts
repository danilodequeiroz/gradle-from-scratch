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