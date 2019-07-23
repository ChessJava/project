package com.test.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebappAdapter implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		MyInterceptor mi = new MyInterceptor();
		registry.addInterceptor(mi)
				.addPathPatterns("/**").excludePathPatterns(mi.getUrl());
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
