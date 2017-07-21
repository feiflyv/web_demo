define(['app'], function (app) {
	var injectParams = ['$scope','$http','$q','ngTableParams','repoService','utilService'];
	var sysUserCtrl = function($scope,$http,$q,ngTableParams,repo,util){
		InitiateWidgets();
		$scope.param={};
		$scope.users = [];
		var opts = {
			url:'/sys/user',
			editView: '/sys/user/editView',
			showName:'用户'
		};
		$scope.userTable = new ngTableParams({page:1,count:10},{
	        total: 0,
	        getData: function($defer, params) {
	        	repo.query(opts, util.buildQueryParam(params.$params,$scope.param))
	        	.then(function(data){
                    params.total(data.total);
                    $defer.resolve($scope.users = data.data);
	        	});
	        }
	    });
		
		$scope.selectAll = {checked:false};
		$scope.$watch('selectAll.checked', function(value){
			angular.forEach($scope.users, function(o){
				o.$selected = value;
			});
		});
	    
	    $scope.showAdd = function(){
	    	util.commonModal($scope,'新增用户',opts.editView,function(modal){
	    		var mScope = modal.$scope;
            	mScope.user = {};
            	mScope.okBtn = {
            		text:'新增',
            		click: function(){$scope.doSave(modal, mScope)}
            	}
	    	});
	    }
		$scope.doSave = function(modal, mScope){
			if(angular.isDefined(mScope.user.userid)){
				repo.update(opts, mScope.user).then(function(data){
					$scope.userTable.reload();
				});
			} else {
				repo.add(opts, mScope.user).then(function(data){
					$scope.userTable.reload();
				});
			}
			util.hideModal(modal);
		}
		$scope.showUpdate = function(item){
			repo.get(opts, item.id).then(function(data){
				util.commonModal($scope,'修改用户',opts.editView,function(modal){
					var mScope = modal.$scope;
	            	mScope.user = data;
	            	mScope.okBtn = {
	            		text:'修改',
	            		click: function(){$scope.doSave(modal, mScope)}
	            	}
				});
			});
		}
		$scope.doDel = function(){
			repo.remove(opts, $scope.users, 'id').then(function(data){
        		$scope.userTable.reload();
        	});
		}
	};
	
	sysUserCtrl.$inject = injectParams;
    app.register.controller('sysUserCtrl', sysUserCtrl);
});