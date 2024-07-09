import com.github.danilodequeiroz.gradlefundamentals.Slf4jSimpleRule
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileTestJava

plugins {
    id("java")
    id("com.diffplug.spotless")
    //id("com.autonomousapps.dependency-analysis")
}
/**
 * If you run the ':dependencies' task and you see something weird in there, which you didn't expect, and
 * then find out that the metadata of one component is not as it should be, you can use such rules to adjust it.
 */
dependencies.components {
    withModule<Slf4jSimpleRule>("org.slf4j:slf4j-simple")
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