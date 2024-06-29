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