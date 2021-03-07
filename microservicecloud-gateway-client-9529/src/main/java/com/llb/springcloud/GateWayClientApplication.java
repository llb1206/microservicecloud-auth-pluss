package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GateWayClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayClientApplication.class, args);
    }

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is first messge";
    }
}
