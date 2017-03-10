define([], function(){
	/**
     * 路由设置函数，所以这里定义setRoute
     * @param {[type]} url        [模块相对路径]
     * @param {[type]} ctrl       [Controller名称]
     * @param {[type]} reqJs      [模块对应的控制器JS文件]
     */
	function setRoute(url, label, ctrl, reqJs){
		var routeDef = {};
		routeDef.templateUrl = addContext(url);
		routeDef.controller = ctrl;
		routeDef.label = label;
		routeDef.resolve = {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var defer = $q.defer();
	            require([addContext("/app/controllers" + reqJs)], function () {
	                defer.resolve();
	                $rootScope.$apply();
	            });
	            return defer.promise;
	        }]
		};
		return routeDef;
	}
	var app = angular.module('shikeApp', ['ngRoute','ngResource','ngSanitize','mgcrea.ngStrap','ngTable','ng-breadcrumbs']);
	app.config(function($routeProvider,$controllerProvider,$provide,$httpProvider,$datepickerProvider){
		
		app.register = {
		        controller: $controllerProvider.register,
		        factory: $provide.factory,
		        service: $provide.service
		};
		
		/** 设置路由 */
		$routeProvider
		/** 系统用户管理模块，/sys/user对应于菜单栏地址 */
		.when('/sys/user', setRoute('/sys/user/index','系统用户','sysUserCtrl','/sys/user.js'))
		.when('/', {templateUrl:_context+'/home',controller :'homeCtrl',label:'主页'});
		
		angular.extend($datepickerProvider.defaults, {
		    dateFormat: 'yyyy-MM-dd',
		    dateType:'string',
		    startWeek: 1
		});
		
		$httpProvider.interceptors.push(function() {
			return {
				'response':function(resp) {
					var headers = resp.headers();
					if(angular.isDefined(headers['access-state']) && headers['access-state'] == 'login'){
						location.href = addContext('/login');
					} else {
						return resp;
					}
				}
			};
		});
	}).controller("homeCtrl", function($scope,breadcrumbs){//主模块
		$scope.breadcrumbs = breadcrumbs;
	});
	return app;
});
