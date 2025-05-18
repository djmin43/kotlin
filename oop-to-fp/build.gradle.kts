plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2") // or JUnit 5: testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.2") // Required for running JUnit 4 tests with JUnit 5
}

tasks.test {
    useJUnitPlatform()
}