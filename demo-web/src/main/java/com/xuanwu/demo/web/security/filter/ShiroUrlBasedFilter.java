package com.xuanwu.demo.web.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.xuanwu.demo.common.entity.RolePermission;
import com.xuanwu.demo.web.WebConstants;

/**
 * @desc 权限过滤器，对所有的URL进行过滤，对于没有授权的访问，将拒绝
 * @author s.y
 * @2015年4月4日
 * @version 1.0.0
 */
public class ShiroUrlBasedFilter extends AuthorizationFilter {
		
	@Override
	protected boolean isAccessAllowed(ServletRequest req,
			ServletResponse resp, Object mappedValue) throws Exception {
		HttpServletRequest hreq = (HttpServletRequest)req;
		HttpServletResponse hresp = (HttpServletResponse)resp;
		Subject subject = SecurityUtils.getSubject();
		boolean isPermitted = false;
		if(subject.isAuthenticated()){
			RolePermission perm = new RolePermission();
			String url = hreq.getServletPath();
			if(StringUtils.isBlank(url)){
				url = hreq.getPathInfo();//fixed for IBM WebSphere 
			}
			perm.setBaseUrl(url);
			isPermitted = subject.isPermitted(perm);
			if(!isPermitted){
				hresp.setHeader(WebConstants.HEADER_ACCESS_STATE, "unauthorized");
			}
		} else {
			hresp.setHeader(WebConstants.HEADER_ACCESS_STATE, "login");
		}
		return isPermitted;
	}
	
	@Override
	protected void postHandle(ServletRequest req, ServletResponse resp)
			throws Exception {
		//HttpServletRequest hreq = (HttpServletRequest)req;
		//do record log
	}	
}
