plugins {
    id("org.springframework.boot")  version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

group = "com.batch"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":job-sample"))
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.apache.commons:commons-dbcp2:2.12.0")

    runtimeOnly ("com.h2database:h2")



    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.springframework.batch:spring-batch-test")
}

tasks.test {
    useJUnitPlatform()
}