plugins {
    `java-library`
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":user-service:user-domain"))
    implementation("org.postgresql:postgresql")
}
