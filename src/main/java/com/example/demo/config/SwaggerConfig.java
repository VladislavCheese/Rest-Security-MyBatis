package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс - конфигурация работы со Swagger.
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Students and Teachers API")
                .version(("v1.0.1"))
                .contact(new Contact()
                        .email("89851502703l@gmail.com")
                        .name("VladislavCh")
                ));
    }
}
