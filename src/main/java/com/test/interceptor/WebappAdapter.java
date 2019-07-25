package com.test.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebappAdapter implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		MyInterceptor mi = new MyInterceptor();
		// 将自定义拦截器加入到MVC拦截器管理中心
		registry.addInterceptor(mi)
				// 设置拦截的请求，这里的"**"为拦截所有请求
				.addPathPatterns("/**")
				// 设置不拦截的请求
				.excludePathPatterns(mi.getUrl());
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
