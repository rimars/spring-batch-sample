import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("org.springframework.boot")  version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.0"
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
    implementation("org.springframework:spring-jdbc")  // Spring JDBC
//    runtimeOnly ("com.h2database:h2")

    implementation("org.postgresql:postgresql:42.6.1")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.springframework.batch:spring-batch-test")
}

tasks {
    // JAR 파일 생성 시 MANIFEST에 Main-Class를 추가하는 부분
//    jar {
//        finalizedBy shadowJar
//
//        manifest {
//            attributes(
//                "Main-Class" to "org.springframework.batch.core.launch.support.CommandLineJobRunner"
//            )
//        }
//    }

    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "org.springframework.batch.core.launch.support.CommandLineJobRunner"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

tasks.test {
    useJUnitPlatform()
}