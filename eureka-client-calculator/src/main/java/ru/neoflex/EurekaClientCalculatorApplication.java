package ru.neoflex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientCalculatorApplication.class, args);
    }

}
