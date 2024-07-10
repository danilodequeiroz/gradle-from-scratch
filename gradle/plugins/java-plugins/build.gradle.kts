plugins {
    //`kotlin-dsl` // ! id("kotlin-dsl")
    id("java-gradle-plugin")
}

gradlePlugin {
    plugins.create("MyJavaBase"){
        id = "my-java-base"
        implementationClass = "com.github.danilodequeiroz.gradlefundamentals.MyJavaBasePlugin"
    }
    plugins.create("MyJavaLibrary"){
        id = "my-java-library"
        implementationClass = "com.github.danilodequeiroz.gradlefundamentals.MyJavaLibraryPlugin"
    }
    plugins.create("MyJavaApplication"){
        id = "my-application"
        implementationClass = "com.github.danilodequeiroz.gradlefundamentals.MyJavaApplicationPlugin"
    }
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.25.0")
}