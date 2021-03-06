package com.llb.client;


import com.llb.client.hystrix.AuthServiceHystrix;
import com.llb.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth-service",fallback =AuthServiceHystrix.class )
public interface AuthServiceClient {
//org.springframework.security.oauth2.provider.endpoint
    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);

}



