package com.acme.inventory.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class OpenApiConfig {

  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("My API")
                .version("1.0")
                .description("API documentation for my application"));
  }
}
