package com.llb.web;

import com.llb.dto.UserLoginDTO;
import com.llb.entity.User;
import com.llb.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceDetail userServiceDetail;

	@PostMapping("/register")
	public void postUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		// 参数判断，省略
		userServiceDetail.insertUser(username, password);
	}

	@PostMapping("/login")
	public UserLoginDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
		// 参数判断，省略
		return userServiceDetail.login(username, password);
	}

	@PostMapping("/update")
	public UserLoginDTO update(@RequestParam("username") String username, @RequestParam("password") String password) {
		// 参数判断，省略
		return userServiceDetail.login(username, password);
	}
}
