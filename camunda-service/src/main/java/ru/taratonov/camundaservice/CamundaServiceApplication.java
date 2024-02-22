package ru.taratonov.camundaservice;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class CamundaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaServiceApplication.class, args);
    }

}
