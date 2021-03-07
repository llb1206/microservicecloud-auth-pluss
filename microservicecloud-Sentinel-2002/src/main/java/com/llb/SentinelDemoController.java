package com.llb;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelDemoController {

    @SentinelResource(value = "hello", blockHandler = "blockHandlerHello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello Sentinel";
    }
    public String blockHandlerHello(BlockException e) {
        return "限流了";
    }
}