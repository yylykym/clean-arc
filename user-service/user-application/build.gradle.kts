plugins {
    java
}

dependencies {
    implementation(project(":user-service:user-domain"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.13.2")
}
