package com.llb.myrule;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {

    /**
     * 自定义均衡策论****自动以策略哦  在启动类里面引用
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();//这是轮询
        //return new RandomRule();//这才是随机啊
        //return new RandomRule();重置  防止宕机   瑞踹算法
        //return new RandomRule_ZY();//每台机器5次
    }
}
