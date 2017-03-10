define(['app'], function (app) {
	var utilService = function($rootScope,$modal){
		
		var confirmScope = $rootScope.$new();
		
		var hideModal = function(modal){
			modal.$promise.then(modal.hide);
		}
		
		var selectedItems = function (items){
			var rets = [];
			if(angular.isDefined(items)){
				angular.forEach(items, function(o){
					if(o.$selected == true){
						rets.push(o);
					}
				});
			}
			return rets;
		}
		
		var selectedIds = function (items, idKey){
			var rets = [];
			if(angular.isDefined(items)){
				angular.forEach(items, function(o){
					if(o.$selected == true){
						rets.push(o[idKey]);
					}
				});
			}
			return rets;
		}

		var buildQueryParam = function (tblParam, otherParam){
			return {
				count:tblParam.count,
				page:tblParam.page,
				sorts:tblParam.sorting,
				params:otherParam
			}
		}
		
		var commonModal = function(parentScope,title,contentUrl,init){
			var modal = $modal({scope:parentScope,title:title, 
				template:'modal/common.tpl.html',
				contentTemplate:addContext(contentUrl),show:false,backdrop:'static'});
			modal.$promise.then(function(){
				init(modal);
				modal.show();
			});
			var scope = modal.$scope;
			scope.$on('modal.hide',function(){
				scope.$destroy();
			});
		}
		
		var confirmModal = function(content,okFn){
			var modal = $modal({scope:confirmScope,content:content, 
				template:'modal/confirm.tpl.html',show:true,backdrop:'static'});
			var scope = modal.$scope;
			scope.$on('modal.hide',function(){
				scope.$destroy();
			});
			scope.okBtn = {
				click:function(){
					okFn();
					hideModal(modal);
				}
			}
		}
		
        return {
        	commonModal:commonModal,
            hideModal:hideModal,
            confirm:confirmModal,
            selectedItems:selectedItems,
            selectedIds:selectedIds,
            buildQueryParam:buildQueryParam
        };
	};
	app.factory('utilService', ['$rootScope','$modal',utilService]);
});