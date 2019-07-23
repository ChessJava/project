package com.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chess
 */
public class MyInterceptor implements HandlerInterceptor {

	private List<String> url = new ArrayList<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("-----------拦截器启动-------------------------");
		HttpSession session = request.getSession();
		System.out.println("session中:"+session.getAttribute("user")+"用户登陆");
        if(session.getAttribute("user") != null){
            return true;
        }else{
			//未登录，跳转到登录页
            response.sendRedirect("/login");
            return false;
        }
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	public List<String> getUrl(){

		//设置页面不拦截
		url.add("/login");

		//设置请求不拦截
		url.add("/user/login");
		url.add("/test");

		//设置网站静态资源不拦截
		url.add("/images/**");
		url.add("/js/**");
		url.add("/css/**");
		return url;
	}
	
}
