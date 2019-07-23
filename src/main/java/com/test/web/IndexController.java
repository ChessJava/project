package com.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/show")
	public String indexPage() {
		System.out.println("首页登陆");
		return "show";
	}

	@RequestMapping("/login")
	public String loginPage() {
		System.out.println("跳转登陆页面");
		return "login";
	}

}
