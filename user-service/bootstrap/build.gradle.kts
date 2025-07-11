plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(project(":user-service:user-interfaceadapter"))
    implementation(project(":user-service:user-domain"))
    implementation(project(":user-service:user-application"))
    implementation(project(":user-service:user-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter")
}
