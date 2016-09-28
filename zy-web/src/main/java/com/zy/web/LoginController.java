package com.zy.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zy.service.login.LoginService;
import com.zy.service.login.SessionEntity;
import com.zy.util.FiledsConstant;
import com.zy.util.ResultMap;
import com.zy.web.annotation.FilterCheckUrl;

/***
 * @ClassName: LoginController
 * @Description:用户登录控制器
 * @author chenrui
 * @date 2015-4-8 上午11:36:50
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	@Autowired
	private LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@FilterCheckUrl(value = false)
	@RequestMapping(value="/login")
	public ModelAndView login(ModelMap modelMap) {
		ModelAndView view = new ModelAndView("/account/login",modelMap);
		return view;
	}

	/**
	 * 用户后台登录
	 * 
	 * @param userName
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@FilterCheckUrl(value = false)
	@ResponseBody
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public Object loginIn(String username, String password,HttpServletRequest request, HttpServletResponse response,Model model) {
		try {
			HttpSession session = request.getSession();
			String sessionId = session.getId();
			SessionEntity sessionEntity = loginService.loginIn(username,
					password, sessionId);
			if (null == sessionEntity) {
				return ResultMap.buildMap(500, "用户名密码错误", null);
			}
			session.setAttribute(FiledsConstant.SESSION_KEY, sessionEntity);
			return ResultMap.buildMap(0, "登陆成功", null);
		} catch (Exception e) {
			logger.error("登录失败", e);
			return ResultMap.buildMap(500, "登陆错误", null);
		}
	}

	/**
	 * 用户退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public void loginOut(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (null != session) {
			session.removeAttribute(session.getId());
			session.invalidate();
		}
		try {
			response.sendRedirect("/zy/admin/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
