plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Ensure that Spring Boot builds the JAR correctly
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	// Optionally customize the JAR name here
	archiveBaseName.set("roinventory")
	archiveVersion.set("0.0.1-SNAPSHOT")
}

// This ensures that `bootJar` builds the executable JAR, and it’s the default build task
tasks.named("build") {
	dependsOn("bootJar")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
