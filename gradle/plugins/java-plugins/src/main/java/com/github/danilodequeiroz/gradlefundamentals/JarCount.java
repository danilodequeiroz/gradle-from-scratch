package com.github.danilodequeiroz.gradlefundamentals;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

//@CacheableTask
public abstract class JarCount extends DefaultTask {

    // ** Gradle specific types **

    // ConfigurableFileCollection <- @InputFiles, @OutputFiles
    // RegularFileProperty <- @InputFile, @OutputFile
    // DirectoryProperty <- @InputDirectory, @OutputDirectory

    @InputFiles
    public abstract ConfigurableFileCollection getAllJars();

    @OutputFile
    public abstract RegularFileProperty getCountFile();

    @TaskAction
    public void doCount() throws IOException {
        Set<File> jarFiles = getAllJars().getFiles();
        int count = jarFiles.size();
        File out = getCountFile().get().getAsFile();
        Files.write(out.toPath(), Collections.singleton("" + count));
    }
}