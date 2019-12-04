package com.llb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class T1ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(T1ServiceApplication.class, args);
    }

}
