package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
@EnableEurekaClient

public class DeptProvider8006_Hystrix_App {
    /**
     * 开启 ----特拜恩 Turbine
     * 都是 特拜恩 服务端口  8006
     * 打开:http://localhost:8006/hystrix,输入监控流http://localhost:8006/turbine.stream
     */
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8006_Hystrix_App.class, args);
    }
}
