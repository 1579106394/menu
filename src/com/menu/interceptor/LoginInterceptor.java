package com.menu.interceptor;

import com.menu.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestURI = request.getRequestURI();
		//可以获得是否是登录页面，登录页面我们不进行拦截。
		if(!requestURI.contains("/login")) {
			User user = (User) request.getSession().getAttribute("user");
			if(null == user) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return false;
			}
		}
		return true;
	}

}
