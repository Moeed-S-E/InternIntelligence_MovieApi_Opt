package com.movieapp.main.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie App API")
                        .version("1.0.0")
                        .description("API documentation for the Movie App")
                        .contact(new Contact().name("Muhammad Moeed Sajid").email("mmoeed202@gmail.com")
                        		)
                        );
    }
}