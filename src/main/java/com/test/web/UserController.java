package com.test.web;

import com.test.dao.imp.UserService;
import com.test.entity.Result;
import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/user/login")
	public Result userLogin(HttpSession session,
                            @RequestParam("username")String username,
                            @RequestParam("password")String password) {
		Result result = new Result();
		System.out.println("用户"+username+"登陆");
		System.out.println("账号:"+username);
		System.out.println("密码:"+password);
		User user = userService.findUser(username, password);
		if(user != null) {
			session.setAttribute("user", username);
			result.setResult("请求成功");
			return result;
		}
		result.setResult("请求失败");
		return result;
	}

	@RequestMapping(value = "/test")
	public Result test(@RequestParam(required = false) MultipartFile profile) {
		System.out.println("进入测试请求！！");
		Result result = new Result();
		List<User> list = userService.findAll();
		if(list != null) {
			result.setResult("请求成功");
			result.setObject(list);
			return result;
		}
		result.setResult("请求失败");
		return result;
	}
	
}
