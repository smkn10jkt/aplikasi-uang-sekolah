angular.module('belajar.service', ['ngResource'])
    .factory('ApplicationConfigService', ['$resource', '$http', function($resource, $http){
        var service = {
            applicationConfig: $resource('config/:configId'),
            get: function(param, callback){ return this.applicationConfig.get(param, callback) }, 
            query: function(){ return this.applicationConfig.query() },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('config', obj);
                } else {
                    return $http.put('config/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('config/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    .factory('ApplicationSessionsService', ['$http', function($http){
        var service = {
            list: function(){ 
                return $http.get('homepage/sessioninfo');
            }, 
            kick: function(user){
                return $http.delete('homepage/kick/'+user.sessionid);
            }
        };
            
        return service;
    }])
    .factory('SystemMenuService', ['$resource', '$http', function($resource, $http){
        var service = {
            menu: $resource('menu/:id', {}, {
                queryPage: {method:'GET', isArray: false}
            }),
            get: function(param, callback){ return this.menu.get(param, callback) }, 
            query: function(p, callback){ return this.menu.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('menu', obj);
                } else {
                    return $http.put('menu/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('menu/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    .factory('PermissionService', ['$resource', '$http', function($resource, $http){
        var service = {
            permission: $resource('permission/:id'),
            get: function(param, callback){ return this.permission.get(param, callback) }, 
            query: function(){ return this.permission.query() },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('permission', obj);
                } else {
                    return $http.put('permission/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('permission/'+obj.id);
                }
            }
        };
            
        return service;
    }])
<<<<<<< HEAD
    .factory('paymentsService', ['$resource', '$http', function($resource, $http){
        var service = {
            payments: $resource('master/payments/:id', {},{
                queryPage: {method:'GET', isArray: false}
            }),
            get: function(param, callback){ return this.payments.get(param, callback) }, 
           query: function(p, callback){ return this.payments.queryPage({"page.page": p, "page.size": 10}, callback) },
             save: function(obj){
=======
    .factory('PaymentsService', ['$resource', '$http', function($resource, $http){
        var service = {
            payments: $resource('master/payments/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.payments.get(param, callback) }, 
            query: function(p, callback){ return this.payments.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
>>>>>>> c22c38e111513f4afb5af06fa2afed95024d21cb
                if(obj.id == null){
                    return $http.post('master/payments', obj);
                } else {
                    return $http.put('master/payments/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/payments/'+obj.id);
                }
            },
            unselectedPermission: function(obj){
                return $http.get('role/'+obj.id+'/unselected-permission');
            },
            unselectedMenu: function(obj){
                return $http.get('role/'+obj.id+'/unselected-menu');
            }
        };
            
        return service;
    }])
<<<<<<< HEAD
    
=======
>>>>>>> c22c38e111513f4afb5af06fa2afed95024d21cb
;