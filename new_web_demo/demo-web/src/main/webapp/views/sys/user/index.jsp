<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../config.jsp"%>

<div class="row">
	<div class="col-xs-12 col-md-12">
		<div class="widget">
			<div class="widget-header">
				<span class="widget-caption">用户列表</span>
				<div class="widget-buttons">
					<a href="javascript:;" data-toggle="maximize"><i class="fa fa-expand"></i></a>
				</div>
			</div>
			<div class="widget-body">
				<form class="form-inline table-toolbar">
					<button class="btn btn-sm btn-success" ng-click="showAdd()">
						<i class="fa fa-plus"></i>&nbsp;新增
					</button>
					<button class="btn btn-sm btn-danger" ng-click="doDel()">
						<i class="fa fa-trash"></i>&nbsp;删除
					</button>
					<div class="form-group">
					    <input type="text" class="form-control input-sm" ng-model="param.username" placeholder="用户账号">
					</div>
					<button class="btn btn-sm btn-info" ng-click="userTable.reload()">
						<i class="fa fa-search"></i>&nbsp;查询
					</button>
				</form>
				<table ng-table="userTable" class="table table-striped table-bordered table-hover">
			        <tbody>
			          <tr ng-repeat="user in $data"
			          		ng-click="user.$selected = !user.$selected"
        					ng-class="{'active': user.$selected}">
			          	<td width="30" header="'ng-table/headers/checkbox.html'">
                			<input type="checkbox" ng-checked="user.$selected" />
            			</td>
		            	<td data-title="'用户名'">
		                    {{user.username}}
		                </td>
		            	<td data-title="'操作'" width="100">
		                    <a href="javascript:;" class="btn btn-warning btn-xs" ng-click="showUpdate(user)"><i class="fa fa-edit"></i>修改</a>
		                </td>
			          </tr>
			        </tbody>
			     </table>
			</div>
		</div>
	</div>
</div>