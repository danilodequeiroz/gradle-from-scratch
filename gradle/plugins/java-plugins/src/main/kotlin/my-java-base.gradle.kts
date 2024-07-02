import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileTestJava

plugins {
    id("java")
    id("com.diffplug.spotless")
}

// Extension from the "java", "java-library" and "application" plugins
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

// Always be careful with this setup
// In this case make sense because it's just encoding everything using utf-8,
// but for other configurations wouldn't  be a good practice
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.named<JavaCompile>("compileJava") {} // ==  tasks.compileJava {}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.test {

}

tasks.javadoc {

}