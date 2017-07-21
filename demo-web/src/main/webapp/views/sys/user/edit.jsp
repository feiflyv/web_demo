<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../config.jsp"%>
<form class="form-horizontal" name="form" novalidate>
	<input type="hidden" class="form-control" ng-model="user.id" />
	<div class="form-group">
		<label for="inputUsername" class="col-sm-2 control-label">用户账号</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="inputUsername" ng-model="user.username" required />
		</div>
	</div>
</form>