package com.yylykym.user.adapter.web.config;

import com.yylykym.user.application.usecase.CreateUserUseCase;
import com.yylykym.user.application.usecase.CreateUserUseCaseHandler;
import com.yylykym.user.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCaseHandler(userRepository);
    }
}
