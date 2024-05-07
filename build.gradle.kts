plugins {
    id("java")
}

group = "io.github.meelana"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.2.1")
    implementation("org.slf4j:slf4j-api")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
    useJUnitPlatform()
}