package ru.taratonov.mainservice.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "Camunda service",
        version = "1.0.0",
        contact = Contact(
            name = "Taratonov Vadim",
            email = "vtaratonov@neoflex.ru",
            url = "https://github.com/VadimTaratonov/camunda-test-application"
        )
    )
)
class OpenApiConfig {
}