package com.github.danilodequeiroz.gradlefundamentals;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.Zip;

public abstract class MyJavaApplicationPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
//        plugins {
//            id("application")
//            id("my-java-base")
//        }
        project.getPlugins().apply("application");
        project.getPlugins().apply("my-java-base");
//
//        tasks.register<JarCount>("countJars") {
//            group = "Custom Zipping"
//            description = "Counts!."
//            allJars.from(tasks.jar)
//            allJars.from(configurations.runtimeClasspath)
//            countFile.set(layout.buildDirectory.file("gen/count.txt"))
//        }
        project.getTasks().register("countJars", JarCount.class, task -> {
            task.setGroup("Custom Zipping");
            task.setDescription("Counts!.");
            task.getAllJars().from(project.getTasks().named("jar"));
            task.getAllJars().from(project.getConfigurations().getByName("runtimeClasspath"));
            task.getCountFile().set(
                    project.getLayout().getBuildDirectory().file("gen/count.txt")
            );
        });
//
//        tasks.register<Zip>("bundle") {
//            group = "Custom Zipping"
//            description = "Zipping it all!."
//            from(tasks.jar)
//            from(configurations.runtimeClasspath)
//            destinationDirectory.set(layout.buildDirectory.dir("distribution"))
////    from("build/libs/app.jar")
//        }
        project.getTasks().register("bundle", Zip.class, task -> {
            task.setGroup("Custom Zipping");
            task.setDescription("Counts!.");
            task.from(project.getTasks().getByName("jar"));
            task.from(project.getConfigurations().getByName("runtimeClasspath"));
            task.getDestinationDirectory().set(
                    project.getLayout().getBuildDirectory().dir("distribution")
            );

        });
//
//        tasks.build {
//            dependsOn(tasks.named("bundle"))
//        }
        project.getTasks().named("build", task -> {
            task.dependsOn(project.getTasks().named("bundle"));
        });
//
//        tasks.register("buildsAll") {
//            description = "builds even more.."
//            dependsOn(tasks.build)
//            dependsOn(tasks.named("countJars"))
//        }
        project.getTasks().register("buildsAll", task -> {
            task.setDescription("builds even more..");
            task.dependsOn(project.getTasks().named("build"));
            task.dependsOn(project.getTasks().named("countJars"));
        });
    }
}
