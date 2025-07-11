package com.yylykym.user.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.yylykym.user")
@EntityScan(basePackages = "com.yylykym.user.infrastructure.repository")
@EnableJpaRepositories(basePackages = "com.yylykym.user.infrastructure.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
