plugins{
//    id("java")
    id("java-library") // already applies id("java")
}

// Extension from the "java", "java-library" and "application" plugins
java{

    toolchain.languageVersion.set(JavaLanguageVersion.of(11))

}