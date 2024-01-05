plugins {
	java
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.proj.tech"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework:spring-context-support:6.0.11")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
	testImplementation("org.mockito:mockito-junit-jupiter:5.4.0")
	testImplementation("org.assertj:assertj-core:3.24.2")
	implementation("org.springframework.boot:spring-boot-starter-freemarker")
	implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") // libs to use JPA in your project
	implementation("com.h2database:h2") // libs to use H2 database
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.0.4")
	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.springframework.security:spring-security-web")
	implementation("org.springframework.security:spring-security-config")
	implementation("org.webjars.npm:vue:2.6.14")
	implementation("org.apache.logging.log4j:log4j-api:2.22.1")
	implementation("org.apache.logging.log4j:log4j-core:2.22.1")
}

configurations.all {
	exclude("org.springframework.boot" ,"spring-boot-starter-logging")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
