package com.zy.service.login;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @ClassName: LoginService 
* @Description:后台管理用户登录服务 
* @author chenrui
* @date 2015-4-8 上午10:00:05
 */
@Service
public class LoginService {

	private final static Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Transactional
	public SessionEntity loginIn(String userName,String password,String sessionId) throws Exception {
		logger.info("进入【用户登录】方法，入参[userName=" + userName + "]");

		if("admin".equals(userName) && "admin".equals(password)) {
			SessionEntity sessionEntity = new SessionEntity();
			sessionEntity.setSessionId(sessionId);
			sessionEntity.setUserName(userName);
			sessionEntity.setUserId("123");
			sessionEntity.setLoginDate(new Date());
			return sessionEntity;
		}
		logger.info("退出【用户登录】方法");

		return null;
	}
}