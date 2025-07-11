plugins {
    java                           // 你已在用的
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)  // 你的版本目录
    // —— 加这一行 ——
    id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(project(":user-service:user-domain"))
    implementation(project(":user-service:user-application"))
    implementation(project(":user-service:user-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9")
    // —— 去掉下面这行 ——
    // implementation("org.springdoc.openapi-gradle-plugin:…")
}

// 插件自带的配置 DSL，生成的任务 name 一般是 generateOpenApiDocs
openApi {
    apiDocsUrl.set("http://localhost:8080/v3/api-docs")
    outputDir.set(layout.buildDirectory.dir("openapi"))
    outputFileName.set("openapi.json")
    waitTimeInSeconds.set(10)
}
