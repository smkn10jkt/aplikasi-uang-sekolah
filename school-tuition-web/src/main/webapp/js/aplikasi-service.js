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
    .factory('PaymentsService', ['$resource', '$http', function($resource, $http){
        var service = {
            payments: $resource('master/payments/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.payments.get(param, callback) }, 
            query: function(p, callback){ return this.payments.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
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

    .factory('KelasService', ['$resource', '$http', function($resource, $http){
        var service = {
            kelas: $resource('table/kelas/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.kelas.get(param, callback) }, 
            query: function(p, callback){ return this.kelas.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('table/kelas', obj);
                } else {
                    return $http.put('table/kelas/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('table/kelas/'+obj.id);
                }
            }
            
        };
            
        return service;
    }])
.factory('TahunAjaranService', ['$resource', '$http', function($resource, $http){
        var service = {
            tahunAjaran: $resource('table/tahunAjaran/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.tahunAjaran.get(param, callback) }, 
            query: function(p, callback){ return this.tahunAjaran.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('table/tahunAjaran', obj);
                } else {
                    return $http.put('table/tahunAjaran/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('table/tahunAjaran/'+obj.id);
                }
            }
            
        };
            
        return service;
    }])
.factory('TagihanService', ['$resource', '$http', function($resource, $http){
        var service = {
            tagihan: $resource('table/tagihan/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.Tagihan.get(param, callback) }, 
            query: function(p, callback){ return this.tagihan.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('table/tagihan', obj);
                } else {
                    return $http.put('table/tagihan/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('table/tagihan/'+obj.id);
                }
            }
            
        };
            
        return service;
    }])
.factory('SiswaService', ['$resource', '$http', function($resource, $http){
        var service = {
           siswa: $resource('table/siswa/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.siswa.get(param, callback) }, 
            query: function(p, callback){ return this.siswa.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('table/siswa', obj);
                } else {
                    return $http.put('table/siswa/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('table/siswa/'+obj.id);
                }
            }
            
        };
            
        return service;
    }])
.factory('PembayaranService', ['$resource', '$http', function($resource, $http){
        var service = {
           pembayaran: $resource('table/pembayaran/:id', {},{
                queryPage: {method:'GET', isArray:false}
            }),
            get: function(param, callback){ return this.pembayaran.get(param, callback) }, 
            query: function(p, callback){ return this.pembayaran.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('table/pembayaran', obj);
                } else {
                    return $http.put('table/pembayaran/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('table/pembayaran/'+obj.id);
                }
            }
            
        };
            
        return service;
    }])

;