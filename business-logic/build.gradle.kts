plugins {
    id("java-library") //
}

// Extension from the "java", "java-library" and "application" plugins
java{

    toolchain.languageVersion.set(JavaLanguageVersion.of(11))

}