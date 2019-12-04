package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class Config_3341_StartSpringCloudApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(Config_3341_StartSpringCloudApp.class, args);
	}
}
