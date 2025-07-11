plugins {
    `java-library`
    alias(libs.plugins.spring.dep.mgmt)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":user-service:user-domain"))
    implementation("org.postgresql:postgresql")
}

tasks.named<Jar>("jar") {
    enabled = true
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}