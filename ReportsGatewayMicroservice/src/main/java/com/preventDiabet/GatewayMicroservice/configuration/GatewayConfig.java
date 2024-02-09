package com.preventDiabet.GatewayMicroservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patient-service", r -> r.path("/patientss/**")
                            .uri("http://localhost:8080"))
                .route("doctors-notes-service", r -> r.path("/doctors-notes/**")
                            .uri("http://doctors-notes-service"))
                // Add more routes for other microservices
                .build();
        }


}


