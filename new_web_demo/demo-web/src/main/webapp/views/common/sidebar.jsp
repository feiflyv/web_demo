<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../config.jsp"%>
<!-- Page Sidebar Header-->
<div class="sidebar-header-wrapper">
	<input type="text" class="searchinput"> <i
		class="searchicon fa fa-search"></i>
	<div class="searchhelper">搜索</div>
</div>
<!-- /Page Sidebar Header -->
<!-- Sidebar Menu -->
<ul class="nav sidebar-menu" bs-navbar>
	<li data-match-route="/sys/*"><a href="javascript:;" class="menu-dropdown"><i class="menu-icon fa fa-gears"></i>
			<span class="menu-text">系统管理</span><i class="menu-expand"></i></a>
		<ul class="submenu">
			<li data-match-route="/sys/user"><a href="#/sys/user">
				<span class="menu-text">用户管理</span>
			</a></li>
		</ul>
	</li>
</ul>
<!-- /Sidebar Menu -->