package com.hidden_treasure.common.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedOrigins("https://www.bhohwa.click")
                .allowedOrigins("https://bhohwa.click")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

}
