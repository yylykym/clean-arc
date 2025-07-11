plugins {
    java
    id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
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

// 插件自带的配置 DSL，生成的任务 name 一般是 generateOpenApiDocs
openApi {
    apiDocsUrl.set("http://localhost:8080/v3/api-docs")
    outputDir.set(layout.buildDirectory.dir("openapi"))
    outputFileName.set("openapi.json")
    waitTimeInSeconds.set(10)
}