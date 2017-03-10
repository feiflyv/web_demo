<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webTitle}</title>
<link rel="icon" href="${img}/favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="${vendor}/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${vendor}/bootstrap/css/bootstrap-additions.min.css" />
<link type="text/css" rel="stylesheet" href="${vendor}/font-awesome/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="${vendor}/ng-table/ng-table.css" />
<link type="text/css" rel="stylesheet" href="${vendor}/toastr/toastr.css" />
<link type="text/css" rel="stylesheet" href="${css}/beyond.min.css" />
<script type="text/javascript">
var _context = "${context}";
</script>
<script type="text/javascript" src="${vendor}/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${vendor}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${vendor}/angular/angular.min.js"></script>
<script type="text/javascript" src="${vendor}/angular/angular-route.min.js"></script>
<script type="text/javascript" src="${vendor}/angular/angular-sanitize.min.js"></script>
<script type="text/javascript" src="${vendor}/angular/angular-resource.min.js"></script>
<script type="text/javascript" src="${vendor}/angular-strap/angular-strap.min.js"></script>
<script type="text/javascript" src="${vendor}/angular-strap/angular-strap.tpl.min.js"></script>
<script type="text/javascript" src="${vendor}/ng-table/ng-table.min.js"></script>
<script type="text/javascript" src="${vendor}/toastr/toastr.js"></script>
<script type="text/javascript" src="${vendor}/breadcrumbs/ng-breadcrumbs.js"></script>
</head>
<body style="overflow-x: hidden;" ng-controller="homeCtrl">
<!-- Navbar -->
   <div class="navbar">
   	<jsp:include page="common/header.jsp" />
   </div>
<!-- Main Container -->
   <div class="main-container container-fluid">
	<!-- Page Container -->
       <div class="page-container">
           <!-- Page Sidebar -->
           <div class="page-sidebar" id="sidebar">
           	<jsp:include page="common/sidebar.jsp" />
		</div>
		<!-- Page Content -->
           <div class="page-content">
           	<!-- Page Breadcrumb -->
               <div class="page-breadcrumbs">
               	   <ol class="breadcrumb">
					    <li ng-repeat="breadcrumb in breadcrumbs.get() track by breadcrumb.path" ng-class="{active: $last}">
					      <i ng-if="$first" class="glyphicon glyphicon-home"></i>
					      <a ng-if="!$last" ng-href="\#{{breadcrumb.path}}" ng-bind="breadcrumb.label"></a>
					      <span ng-if="$last" ng-bind="breadcrumb.label"></span>
					    </li>
				   </ol>
               </div>
               <!-- /Page Breadcrumb -->
               <!-- Page Body -->
               <div class="page-body" ng-view></div>
           </div>
	</div>
</div>
<script type="text/javascript" src="${vendor}/require.js" data-main="${context}/app/main"></script>
<script type="text/ng-template" id="ng-table/headers/checkbox.html">
	<input type="checkbox" ng-model="selectAll.checked" />
</script>
<script type="text/ng-template" id="modal/common.tpl.html">
<div class="modal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog {{diagCls ? diagCls : ''}}">
		<div class="modal-content">
			<div class="modal-header" ng-show="title">
				<button type="button" class="close" aria-label="Close" ng-click="$hide()">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" ng-bind="title" style="font-weight:bold;"></h4>
			</div>
			<div class="modal-body" ng-bind="content"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-danger" ng-click="$hide()">关闭</button>
				<button type="button" class="btn btn-sm btn-primary" ng-disabled="form.$invalid || form.$pristine" ng-click="okBtn.click()">{{okBtn.text}}</button>
			</div>
		</div>
	</div>
</div>
</script>

<script type="text/ng-template" id="modal/confirm.tpl.html">
<div class="modal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body" ng-bind="content"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-danger" ng-click="$hide()">取消</button>
				<button type="button" class="btn btn-sm btn-primary" ng-click="okBtn.click()">确定</button>
			</div>
		</div>
	</div>
</div>
</script>
</body>
</html>