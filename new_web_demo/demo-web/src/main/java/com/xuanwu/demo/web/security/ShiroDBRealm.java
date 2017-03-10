package com.xuanwu.demo.web.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xuanwu.demo.common.entity.RolePermission;
import com.xuanwu.demo.web.Urls;

/**
 * @desc 
 * @author s.y
 * @2015年4月4日
 * @version 1.0.0
 */
public class ShiroDBRealm extends AuthorizingRealm {
	
	private static RolePermission mainPerm = new RolePermission(Urls.MAIN);
	private static RolePermission rootPathPerm = new RolePermission(Urls.ROOT);
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		ShiroAuthorizationInfo info = (ShiroAuthorizationInfo) getAuthorizationInfo(principals);
		if (info.getPermission(permission) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		ShiroAuthorizationInfo info = (ShiroAuthorizationInfo) getAuthorizationInfo(principals);
		RolePermission targetPerm = (RolePermission) permission;
		RolePermission perm = info.getPermission(targetPerm.getBaseUrl());
		if (perm != null) {
			targetPerm.setPermissionId(perm.getPermissionId());
			return true;
		}
		//FIXME return true;
		return true;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		checkNotNull(principals, "PrincipalCollection method argument cannot be null.");
		ShiroAuthorizationInfo info = new ShiroAuthorizationInfo();
		info.addPermission(mainPerm); // main page
		info.addPermission(rootPathPerm); // root path "/"
		
		//TODO add other permission
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		checkNotNull(username, "Null username are not allowed by this realm.");
		//TODO check user from DB
		return new SimpleAuthenticationInfo(username, upToken.getPassword(), getName());
	}

	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}
	
}
