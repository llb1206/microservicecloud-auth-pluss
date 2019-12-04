package com.llb.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user/foo")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
        return "i'm foo, " + UUID.randomUUID().toString();
    }

    @RequestMapping("/now")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.printf("当前登陆用户：" + name);
           //获取当前登录用户
        return name;
    }


}
