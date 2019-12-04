package com.llb.springcloud.cfgbeans;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignConfiguration implements RequestInterceptor {


 
@Override
public void apply(RequestTemplate template) {
	

    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    String authorization = request.getHeader("asd");
 
    template.header("asd", authorization);
}
}

