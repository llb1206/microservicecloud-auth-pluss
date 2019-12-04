package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker//开启熔断机制
@EnableHystrixDashboard
@EnableHystrix
@EnableDiscoveryClient
public class DeptProvider8001_Hystrix_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}
	/**
	 * 打开http://localhost:8001/actuator/hystrix.stream可以看到  ping  访问 会有大量json请求数据返回
	 * 
	 * 打开http://localhost:8001/hystrix  可以看到表盘，如果表盘卡住，访问一下 ，输入 http://localhost:8001/actuator/hystrix.stream
	 */
}
