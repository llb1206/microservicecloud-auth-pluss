package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient_3351_StartSpringCloudApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigClient_3351_StartSpringCloudApp.class, args);
	}
}
