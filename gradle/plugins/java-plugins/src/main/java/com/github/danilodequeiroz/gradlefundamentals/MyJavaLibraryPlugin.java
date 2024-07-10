package com.github.danilodequeiroz.gradlefundamentals;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public abstract class MyJavaLibraryPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
//        plugins {
//            id("java-library")
//            id("my-java-base")
//        }
        project.getPlugins().apply("java-library");
        project.getPlugins().apply("my-java-base");
    }
}
