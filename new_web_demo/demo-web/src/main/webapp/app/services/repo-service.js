define(['app'], function (app) {
	var repoService = function($http,$q,util){
		
		var httpPost = function(url, paramObj, onSuccess){
			var defer = $q.defer();
			$http.post(url, angular.toJson(paramObj)).success(function(data, status, headers, config){
        		onSuccess(data, status, headers, config);
        		defer.resolve(data);
        	}).error(function(data, status, headers, config){
        		defer.reject('Http error: ' + status);
        		toastr.error(status + ":" + data);
        	});
			return defer.promise;
		}
		
        return {
            get: function(opts, id){
            	var url = addContext(opts.url + "/" + id);
            	var deferred = $q.defer();
            	$http.get(url).success(function(data, status, headers, config){
            		deferred.resolve(data);
            	}).error(function(data, status, headers, config){
            		defer.reject('Http error: ' + status);
            		toastr.error(status + ":" + data);
            	});
            	return deferred.promise;
            },
            getExt: function(opts, path, id){
            	var url = addContext(opts.url + "/" + path);
            	if(angular.isDefined(id)){
            		url += "/" + id;
            	}
            	var deferred = $q.defer();
            	$http.get(url).success(function(data, status, headers, config){
            		deferred.resolve(data);
            	}).error(function(data, status, headers, config){
            		defer.reject('Http error: ' + status);
            		toastr.error(status + ":" + data);
            	});
            	return deferred.promise;
            },
            add: function(opts, obj){
            	var url = addContext(opts.url) + "/save";
            	var promise = httpPost(url, obj, function(data, status, headers, config){
            		if(data.status == 0){
            			toastr.success("新增" + opts.showName + "成功");
            		} else {
            			toastr.error("新增" + opts.showName + "失败: " + data.errorMsg);
            		}
            	});
            	return promise;
            },
            query: function(opts, params){
            	var url = addContext(opts.url) + "/query";
            	var promise = httpPost(url, params, function(data, status, headers, config){
            		if(data.status != 0){
            			toastr.error("查询" + opts.showName + "失败: " + data.errorMsg);
            		}
            	});
            	return promise;
            },
            update: function(opts, obj){
            	var url = addContext(opts.url) + "/save";
            	var promise = httpPost(url, obj, function(data, status, headers, config){
            		if(data.status == 0){
            			toastr.success("更新" + opts.showName + "成功");
            		} else {
            			toastr.error("更新" + opts.showName + "失败: " + data.errorMsg);
            		}
            	});
            	return promise;
            },
            remove: function(opts, items, idKey){
            	var defer = $q.defer();
            	var ids = util.selectedIds(items, idKey);
            	if(ids.length == 0){
            		toastr.warning("请先选择要删除的" + opts.showName + "");
            		defer.reject();
            		return defer.promise;
            	}
            	util.confirm("确定删除所选"+opts.showName+"？", function(){
            		var url = addContext(opts.url) + "/del";
            		var promise = httpPost(url, ids, function(data, status, headers, config){
            			if(data.status == 0){
                			toastr.success("删除" + opts.showName + "成功");
                		} else {
                			toastr.error("删除" + opts.showName + "失败: " + data.errorMsg);
                		}
                	});
                	promise.then(function(data){
                		defer.resolve(data);
                	});
            	});
            	return defer.promise;
            },
            removeOne: function(opts, id, name){
            	var newOpts = angular.extend([], opts);
            	var items = [{id:id,$selected:true}];
            	if(angular.isDefined(name)){
            		newOpts.showName += "[" + name + "]";
            	}
            	return this.remove(newOpts, items, 'id');
            }
        };
	};
	app.factory('repoService', ['$http','$q','utilService',repoService]);
});