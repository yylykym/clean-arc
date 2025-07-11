package com.yylykym.user.adapter.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig  {

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        // 把 Spring 的 MessageSource 注入给 Validator，让它去读 messages*.properties
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}
