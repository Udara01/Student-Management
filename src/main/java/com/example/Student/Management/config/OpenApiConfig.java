package com.example.Student.Management.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI studentApiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management API")
                        .description("Simple REST API for managing students using Spring Boot and MySQL")
                        .version("1.0.0"));
    }
}
