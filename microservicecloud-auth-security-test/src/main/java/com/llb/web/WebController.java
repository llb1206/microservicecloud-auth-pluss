package com.llb.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class WebController {

    @RequestMapping(value="s1",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.printf("当前登陆用户：" + name);
        return "i'm foo, " + UUID.randomUUID().toString();  
    }
}
