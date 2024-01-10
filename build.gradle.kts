plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "ru.knpp.aseto"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("ru.knpp.aseto.fileosmonitor.MainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "ru.knpp.aseto.fileosmonitor.MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}