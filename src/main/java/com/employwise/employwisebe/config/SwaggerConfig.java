package com.employwise.employwisebe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {

        return new ApiInfo("internship Backend", "This project is developed by Shikhar Batham for internship", "1.0",
                "terms of service", new Contact("Shikhar Batham", "http://shikhar.com", "shikhar.batham@gmail.com"),
                "license of apis", "API License URL", new ArrayList<>());
    }
}
