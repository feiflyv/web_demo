package com.xuanwu.demo.web.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.AuthorizationInfo;

import com.xuanwu.demo.common.entity.RolePermission;

/**
 * @desc 
 * @author s.y
 * @2015年4月4日
 * @version 1.0.0
 */
public class ShiroAuthorizationInfo implements AuthorizationInfo {

	private static final long serialVersionUID = -1233002746492148418L;
	
	private HashMap<String, RolePermission> urlPermMap;

	@Override
	public Collection<String> getRoles() {
		return null;
	}

	@Override
	public Collection<String> getStringPermissions() {
		return null;
	}

	@Override
	public Collection<org.apache.shiro.authz.Permission> getObjectPermissions() {
		return null;
	}
	
	public RolePermission getPermission(String url) {
		if (urlPermMap == null || urlPermMap.isEmpty())
			return null;
		return urlPermMap.get(url);
	}
	
	public Map<String, RolePermission> getPermissions() {
		return urlPermMap;
	}
	
	public void addPermission(RolePermission perm) {
		if (urlPermMap == null) {
			urlPermMap = new HashMap<String, RolePermission>();
		}
		urlPermMap.put(perm.getBaseUrl(), perm);
	}

	public void addPermissions(List<RolePermission> perms) {
		if (perms == null || perms.isEmpty())
			return;
		for (RolePermission perm : perms) {
			addPermission(perm);
		}
	}
}
