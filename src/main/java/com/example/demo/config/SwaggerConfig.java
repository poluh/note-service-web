package com.example.demo.config;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.enums.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.security.*;
import org.springframework.context.annotation.*;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Note Service", version = "1.0"))
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "UserId",
        scheme = "api_key",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
