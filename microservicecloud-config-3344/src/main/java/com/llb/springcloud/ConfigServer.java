package com.llb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    /**
     * 配置中心 一种分为单机模式，根据地址来，不需要注册中心
     *         一种为高可用模式，服务名来，注册中心基础上的
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
}
