package com.llb.client.hystrix;


import com.llb.client.AuthServiceClient;
import com.llb.entity.JWT;
import org.springframework.stereotype.Component;


@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
