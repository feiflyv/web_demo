package com.xuanwu.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuanwu.demo.web.Urls;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = Urls.LOGIN, method = RequestMethod.GET)
	public void index(Model model) {
		
	}
	
	@RequestMapping(value = Urls.LOGIN, method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model, 
			String name, String password) {
		try {
			logger.info(name + "--" + password);
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			subject.login(token);
			return "redirect:" + Urls.ROOT;
		} catch (UnknownAccountException uae ) {
		    //username wasn't in the system, show them an error message?
		} catch (IncorrectCredentialsException ice ) {
		    //password didn't match, try again?
		} catch (LockedAccountException lae ) {
		    //account for that username is locked - can't login.  Show them a message?
		} catch ( AuthenticationException ae ) {
		    //unexpected condition - error?
		}
		return Urls.LOGIN;
	}
	
	@RequestMapping(value = Urls.LOGOUT)
	public String logout(Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:" + Urls.LOGIN;
	}
	
	@RequestMapping(value = Urls.ROOT)
	public String root(Model model){
		return Urls.MAIN;
	}
	
	@RequestMapping(value = Urls.HOME)
	public void home(Model model){
		
	}
}
