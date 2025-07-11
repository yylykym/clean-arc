plugins {
    java
}

dependencies {
    implementation(project(":user-service:user-domain"))
    implementation(project(":user-service:user-application"))
    implementation(project(":user-service:user-infrastructure"))
    implementation(project(":user-service:user-interfaceadapter"))
}
