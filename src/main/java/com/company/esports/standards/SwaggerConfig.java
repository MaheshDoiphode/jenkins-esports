package com.company.esports.standards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "scheme1",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition(

        info = @Info(
                title = "Unlocking Potential with SpringBOOT-Powered Electronic Store API",
                description = "shshshs"
//                version = "1.0V",

        ))
public class SwaggerConfig {

}