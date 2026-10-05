package com.prasu.microservice.order_service.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI orderServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Order Service")
                        .description("This is the REST API order service")
                        .version("1.0")
                        .license(new License().name("Apache 2.0")));
    }
}
