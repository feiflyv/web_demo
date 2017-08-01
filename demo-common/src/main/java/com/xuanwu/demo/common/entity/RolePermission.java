package com.xuanwu.demo.common.entity;

import org.apache.shiro.authz.Permission;

/**
 * 
 * @Description 
 * @author Beck Wu
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
public class RolePermission implements org.apache.shiro.authz.Permission {

	/** permission id */
	private Integer permissionId;

	/** base URL: '/' + area_name + '/' + controller_name + '/' + action_name */
	private String baseUrl;

	/** role id */
	private Integer roleId;

	public RolePermission() {
	}

	public RolePermission(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RolePermission other = (RolePermission) obj;
		if (baseUrl == null) {
			if (other.baseUrl != null) {
				return false;
			}
		} else if (!baseUrl.equals(other.baseUrl)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean implies(Permission p) {
		return false;
	}

}
