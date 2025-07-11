plugins {
    java
    alias(libs.plugins.spring.dep.mgmt)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(project(":user-service:user-domain"))
    implementation(project(":user-service:user-application"))
    implementation(project(":user-service:user-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9")
}



tasks.named<Jar>("jar") {
    enabled = true
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}