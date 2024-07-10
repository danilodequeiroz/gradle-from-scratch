package com.github.danilodequeiroz.gradlefundamentals;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.api.tasks.testing.Test;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public abstract class MyJavaBasePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
//        plugins {
//            id("java")
//            id("com.diffplug.spotless")
//            //id("com.autonomousapps.dependency-analysis")
//        }
        project.getPlugins().apply("java");
        project.getPlugins().apply("com.diffplug.spotless");
//
//        sourceSets.main {
////    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
//        }
//
//        sourceSets.test {
//
//        }
//
//        sourceSets.create("integrationTest")
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
        sourceSets.create("integrationTest");

//
//        tasks.register<Test>("integrationTest") {                               // Basically the task needs to know about two things:
//            testClassesDirs = sourceSets["integrationTest"].output.classesDirs // (1) where the tests are located and
//            classpath = sourceSets["integrationTest"].runtimeClasspath         // (2) what the classpath of the tests is.
//            useJUnitPlatform()
//        }

        project.getTasks().register("integrationTest", Test.class, test -> {
            test.setTestClassesDirs(
                sourceSets.getByName("integrationTest").getOutput().getClassesDirs()
            );
            test.setClasspath(
                sourceSets.getByName("integrationTest").getCompileClasspath()
            );
            test.useJUnitPlatform();
        });

//
///**
// * If you run the ':dependencies' task and you see something weird in there, which you didn't expect, and
// * then find out that the metadata of one component is not as it should be, you can use such rules to adjust it.
// */
//        dependencies.components {
//            withModule<Slf4jSimpleRule>("org.slf4j:slf4j-simple")
//        }
        project.getDependencies().getComponents()
                .withModule(
                        "org.slf4j:slf4j-simple", Slf4jSimpleRule.class
                );
//
//// Extension from the "java", "java-library" and "application" plugins
//        java {
//            toolchain.languageVersion.set(JavaLanguageVersion.of(11))
//        }
        JavaPluginExtension java = project.getExtensions().getByType(JavaPluginExtension.class);
        java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(11));
//
//        tasks.compileJava {
//            options.encoding = "UTF-8"
//        }
        project.getTasks().withType(JavaCompile.class).configureEach( javaCompile ->
                javaCompile.getOptions().setEncoding("UTF-8")
        );
//
//        tasks.test {
//            useJUnitPlatform {
//                excludeTags("slow")
//            }
//            maxParallelForks = 8
//            maxHeapSize = "4g"
//        }
        project.getTasks().named("test", Test.class, test->{
                test.useJUnitPlatform(junit->{
                    junit.excludeTags("slow");
                });
                test.setMaxParallelForks(8);
                test.setMaxHeapSize("4g");
        });
///*
//    With this setup, we split the execution of tests from the test source set into two groups.
//    This could be used, for example, to make it clear that certain tests are quite slow and probably only
//    should run on CI. So that if you run tests locally, they would be excluded,
//    but they won't be excluded if you do a complete ':check' run.
// */
//        tasks.register<Test>("testSlow") {                        // Basically the task needs to know about two things:
//            testClassesDirs = sourceSets.test.get().output.classesDirs // (1) where the tests are located and
//            classpath = sourceSets.test.get().runtimeClasspath         // (2) what the classpath of the tests is.
//            useJUnitPlatform {
//                includeTags("slow")
//            }
//        }
        project.getTasks().register("testSlow", Test.class, test -> {
            test.setTestClassesDirs(
                    sourceSets.getByName("test").getOutput().getClassesDirs()
            );
            test.setClasspath(
                    sourceSets.getByName("test").getCompileClasspath()
            );
            test.useJUnitPlatform(junit -> {
                junit.excludeTags("slow");
            });
        });
///*
//    This complements the previous block
// */
//        tasks.check {
//            dependsOn(tasks.named("testSlow"))
//        }
        project.getTasks().named("check", check ->{
            check.dependsOn(project.getTasks().named("testSlow"));
        });
    }
}
