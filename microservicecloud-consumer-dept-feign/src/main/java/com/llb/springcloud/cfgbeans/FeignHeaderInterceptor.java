//package com.llb.springcloud.cfgbeans;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
//
//@Component
//public class FeignHeaderInterceptor implements RequestInterceptor {
//
//    @Override
//    public void apply(RequestTemplate template) {
//        /**
//          header传递器
//         */
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                String name = headerNames.nextElement();
//                String values = request.getHeader(name);
//                template.header(name, values);
//            }
//        }
//    }
//}
