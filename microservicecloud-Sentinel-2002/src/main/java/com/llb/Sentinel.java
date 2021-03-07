package com.llb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.sql.DataSource;

/**

* @author 作者 llb:

* @version 创建时间：2019年5月7日 下午2:40:07

* 类说明   没有配置成功

*/
@SpringBootApplication
@EnableEurekaClient
public class Sentinel {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel.class, args);
    }
}
