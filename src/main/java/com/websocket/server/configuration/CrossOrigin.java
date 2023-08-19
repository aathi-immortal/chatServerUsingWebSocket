package com.websocket.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CrossOrigin implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/chat") // Replace with your WebSocket endpoint
                .allowedOrigins("http://169.254.167.2:8080/") // Replace with the domain of your JavaScript client
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
                .allowedHeaders("*") // Specify allowed headers
                .allowCredentials(true); // Allow credentials (cookies, etc.)
    }
}
