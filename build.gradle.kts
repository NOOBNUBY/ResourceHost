import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradleup.shadow") version "8.3.0"
	id("io.ktor.plugin") version "3.0.0-rc-1"
	id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = property("group")!!
version = property("version")!!

val paper_version: String by project
val kyori_version: String by project

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}


application {
	mainClass.set("com.noobnuby.plugin.MainKt")

	val isDevelopment: Boolean = project.ext.has("development")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    compileOnly("io.papermc.paper:paper-api:${paper_version}-R0.1-SNAPSHOT")
	implementation("io.ktor:ktor-server-core-jvm")
	implementation("io.ktor:ktor-server-netty-jvm")
	implementation("io.ktor:ktor-client-core-jvm")
	implementation("io.ktor:ktor-client-cio-jvm")
	implementation("net.kyori:adventure-api:${kyori_version}")
	implementation("net.kyori:adventure-text-minimessage:${kyori_version}")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

kotlin {
    jvmToolchain(17)
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<KotlinCompile> {
        compilerOptions {
            noJdk = false
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }

	shadowJar {
		archiveBaseName.set(rootProject.name)
		archiveClassifier.set("")

		from(sourceSets["main"].output)
	}

	runServer {
		minecraftVersion("1.20.4")
	}
}