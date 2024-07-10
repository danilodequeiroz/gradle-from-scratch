import com.github.danilodequeiroz.gradlefundamentals.JarCount

plugins {
    id("application")
    id("my-java-base")
}

tasks.register<JarCount>("countJars") {
    group = "Custom Zipping"
    description = "Counts!."
    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)
    countFile.set(layout.buildDirectory.file("gen/count.txt"))
}

tasks.register<Zip>("bundle") {
    group = "Custom Zipping"
    description = "Zipping it all!."
    from(tasks.jar)
    from(configurations.runtimeClasspath)
    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
//    from("build/libs/app.jar")
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

tasks.register("buildsAll") {
    description = "builds even more.."
    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}