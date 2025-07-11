package com.yylykym.user.adapter.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springdocOpenApi() {
        Info info = new Info();
        info.setTitle("User Service API");
        info.setDescription("用户模块接口文档");
        info.setVersion("v1.0.0");
        info.contact(new Contact().name("Ylykym").email("yylykym3@outlook.com"));
        return new OpenAPI()
                .info(info);

    }

}
