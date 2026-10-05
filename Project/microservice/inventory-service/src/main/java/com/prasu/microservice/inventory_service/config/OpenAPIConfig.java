package com.prasu.microservice.inventory_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI inventoryServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Inventory Service")
                        .description("This is the REST API inventory service")
                        .version("1.0")
                        .license(new License().name("Apache 2.0")));
    }
}
