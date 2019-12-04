package com.llb.web;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping("/ss")
    public String postUser(){
        //参数判断，省略
       return "Hello";
    }


}
