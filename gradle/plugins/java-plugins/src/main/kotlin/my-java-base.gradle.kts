import com.github.danilodequeiroz.gradlefundamentals.Slf4jSimpleRule
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.compileTestJava
import gradle.kotlin.dsl.accessors._a36adeff7943c18d5e9e07d718caef3f.sourceSets

plugins {
    id("java")
    id("com.diffplug.spotless")
    //id("com.autonomousapps.dependency-analysis")
}

sourceSets.main {
//    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
}

sourceSets.test {

}

sourceSets.create("integrationTest")

tasks.register<Test>("integrationTest") {                               // Basically the task needs to know about two things:
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs // (1) where the tests are located and
    classpath = sourceSets["integrationTest"].runtimeClasspath         // (2) what the classpath of the tests is.
    useJUnitPlatform()
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
    useJUnitPlatform {
        excludeTags("slow")
    }
    maxParallelForks = 8
    maxHeapSize = "4g"
}
/*
    With this setup, we split the execution of tests from the test source set into two groups.
    This could be used, for example, to make it clear that certain tests are quite slow and probably only
    should run on CI. So that if you run tests locally, they would be excluded,
    but they won't be excluded if you do a complete ':check' run.
 */
tasks.register<Test>("testSlow") {                        // Basically the task needs to know about two things:
    testClassesDirs = sourceSets.test.get().output.classesDirs // (1) where the tests are located and
    classpath = sourceSets.test.get().runtimeClasspath         // (2) what the classpath of the tests is.
    useJUnitPlatform {
        includeTags("slow")
    }
}
/*
    This complements the previous block
 */
tasks.check {
    dependsOn(tasks.named("testSlow"))
}

tasks.javadoc {

}