plugins{
    id("java-platform") // Similar to BOM == Bill of Material, which you may know from Maven
}

group = "com.github.danilodequeiroz"

javaPlatform.allowDependencies()

dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.17.2"))
    api(platform("org.junit:junit-bom:5.10.3"))
//    api(platform("org.junit:junit-bom:5.8.2"))
}

dependencies.constraints {
    api(constraintNotation = "org.apache.commons:commons-lang3:3.14.0")
    api(constraintNotation = "org.slf4j:slf4j-api:2.0.13")
    api(constraintNotation = "org.slf4j:slf4j-simple:2.0.13")
}