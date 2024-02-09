package com.preventDiabet.GatewayMicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// On active les clients Feign au niveau com.preventDiabet
@EnableFeignClients("com.preventDiabet")
// EnableFeignClients(basePackages = "com.preventDiabet")



// public class ReportsGatewayMicroserviceApplication implements CommandLineRunner {
public class ReportsGatewayMicroserviceApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ReportsGatewayMicroserviceApplication.class, args);
    }
}
