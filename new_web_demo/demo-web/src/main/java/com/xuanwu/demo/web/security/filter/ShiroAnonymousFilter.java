package com.xuanwu.demo.web.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

import com.xuanwu.demo.web.WebConstants;

public class ShiroAnonymousFilter extends PathMatchingFilter {

	@Override
	protected boolean preHandle(ServletRequest req, ServletResponse resp)
			throws Exception {
		HttpServletResponse hresp = (HttpServletResponse)resp;
		hresp.setHeader(WebConstants.HEADER_ACCESS_STATE, "login");
		return true;
	}
	
}
