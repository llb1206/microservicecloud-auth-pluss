package com.llb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.llb.springcloud.bean.Dept;

@RestController
public class DeptController_Consumer {
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    /*
     * 暴露的是80端口requestmapping  但是实际地下干活的是生产者的8001
     *
     *
     */
    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    //************************************************************
    @Autowired
    private RestTemplate restTemplate;//注意 RestTemplate不是空的！！！！！！！80端口默认不加端口号

    //************************************************************

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        System.out.println(dept);
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);

    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
