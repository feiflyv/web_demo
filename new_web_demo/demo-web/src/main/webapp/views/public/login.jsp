<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webTitle}-用户登录</title>
<link rel="icon" href="${img}/favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="${vendor}/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${css}/beyond.min.css" />
<script type="text/javascript" src="${vendor}/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${vendor}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${vendor}/angular/angular.min.js"></script>
<script type="text/javascript">
var loginMod = angular.module('loginMod', []);
loginMod.controller('loginCtrl', function($scope) {
	$scope.formData = {};
	$scope.processForm = function() {
		//$scope.password = "htmldfdfd";
	};
});
</script>
</head>
<body ng-app="loginMod" ng-controller="loginCtrl">
	<div class="login-container animated fadeInDown">
		<form name="loginForm" action="${context}/public/login" method="post" ng-submit="processForm()" novalidate>
			<input type="hidden" name="token" value="${token}" />
			<div class="loginbox">
				<div class="loginbox-title">欢迎使用</div>
				<div class="loginbox-textbox" ng-class="{'has-error':loginForm.name.$invalid && !loginForm.name.$pristine}">
					<input class="form-control" placeholder="用户名" type="text" name="name" ng-model="login.name" required />
				</div>
				<div class="loginbox-textbox" ng-class="{'has-error':loginForm.password.$invalid && !loginForm.password.$pristine}">
					<input type="password" class="form-control" placeholder="密码" name="password" ng-model="login.password" required />
				</div>
				<div class="loginbox-submit">
					<input class="btn btn-primary btn-block" value="登录" type="submit" ng-disabled="loginForm.$invalid">
				</div>
			</div>
			<div class="logobox"></div>
		</form>
	</div>
</body>
</html>