package com.llb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.llb.springcloud.bean.Dept;
import com.llb.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TurbineController001 {

    @Autowired
    private DeptService service = null;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get") // 只有出现异常，才会触发熔断哦！！！
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("调用其他服务，假如服务关闭简单模拟模拟");
        }
        /**
         * Feign中使用断路器  都差不多 ，不做赘述
         */
        return dept;
    }

    /**
     * //AOP思想 DeptClientServiceFallbackFactory实现加载DeptClientService的熔断接口  对这个创建熔断DeptClientService
     * //这跟查询不到有本质区别，一个是
     * //关闭服务，一个是服务异常，这是熔断跟降级的本质却别
     */

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
