package com.llb.service;


import com.llb.client.AuthServiceClient;
import com.llb.dao.UserDao;
import com.llb.dto.UserLoginDTO;
import com.llb.entity.JWT;
import com.llb.entity.User;
import com.llb.exception.UserLoginException;
import com.llb.utils.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserDao userRepository;
    @Autowired
    AuthServiceClient client;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.printf("开始查询name，返回权限集合*-*-*-*-*-*-*-*-*-*");
        return userRepository.findByUsername(username);
    }

    public void insertUser(String username,String  password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        System.out.printf("将要执行插入sql*-*-*-*-*-*-*-**-*-*-");
        userRepository.save(user);
    }

    public void updateUser(String username,String  password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        System.out.printf("将要即将修改-");
        userRepository.updateUser(user);
    }

    public UserLoginDTO login(String username,String password){
        System.out.println("根据name查用户user");
        User user=userRepository.findByUsername(username);
        if (null == user) {
          throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){

            throw new UserLoginException("error password");
        }

        System.out.println("发送请求的密码为"+password);
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",username,password);
        //获取jwt需要再次验证

        // 获得用户菜单
        if(!(jwt==null)){
            System.out.println("feign取得token-jwt"+jwt.toString());
        }

        // 获取token
        if(jwt==null){
            throw new UserLoginException("jwt 请求为null");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;

    }
}
