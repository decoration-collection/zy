package com.zy.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zy.util.FiledsConstant;
import com.zy.web.annotation.FilterCheckUrl;


/**
* @ClassName: CommonInterceptor 
* @Description:后台请求拦截器 
* @author chenrui
* @date 2015-4-10 下午4:49:17
 */
public class CommonInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		System.out.println("url=" + url);
		
		HandlerMethod method = (HandlerMethod) handler;
		//自定义注解，显示注明不需要过滤该url
		FilterCheckUrl filterCheckUrl = method.getMethodAnnotation(FilterCheckUrl.class);
		if(null != filterCheckUrl && !filterCheckUrl.value()) {
			return true;
		}
		if(url.contains(FiledsConstant.MANAGER_PREX_URL)) {
			HttpSession session = request.getSession();
			if(null == session.getAttribute(FiledsConstant.SESSION_KEY)) {
				response.sendRedirect("/zy/admin/login");
				return false;
			}
		} 
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

	

}