package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {
/**
 * 无用，9001不需要，在8001即可
 * @param args
 */
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}
}
