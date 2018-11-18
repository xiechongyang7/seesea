package com.seesea.seesealogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SeeseaLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeeseaLoginApplication.class, args);
    }
}
