package com.example.az_cicd_application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {

        return """
                Deployment successful!
                Application: Azure CI/CD Demo
                Version: v2
                """;
    }

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of("status", "UP");
    }
}
