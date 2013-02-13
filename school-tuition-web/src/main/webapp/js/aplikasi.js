angular.module('belajar', ['ui', 'belajar.controller'])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider
            .when('/', {templateUrl: 'pages/home.html'})
            .when('/401', {templateUrl: 'pages/404.html', controller: 'LoginRedirectorController'})
            .when('/system/config', {templateUrl: 'pages/system/config.html', controller: 'ApplicationConfigController'})
            .when('/system/sessions', {templateUrl: 'pages/system/sessions.html', controller: 'ApplicationSessionsController'})
            .when('/system/user', {templateUrl: 'pages/system/user.html', controller: 'UserController'})
            .when('/system/role', {templateUrl: 'pages/system/role.html', controller: 'RoleController'})
            .when('/system/permission', {templateUrl: 'pages/system/permission.html', controller: 'PermissionController'})
            .when('/system/menu', {templateUrl: 'pages/system/menu.html', controller: 'SystemMenuController'})
            .when('/master/jenisbiaya', {templateUrl: 'pages/master/jenisbiaya.html', controller: 'JenisbiayaController'})
            .when('/notifications/sms', {templateUrl: 'pages/notifications/sms.html'})
			.when('/notifications/email', {templateUrl: 'pages/notifications/email.html'})
            .when('/master/period', {templateUrl: 'pages/master/period.html', controller: 'PeriodController'})
            .when('/master/konfigurasitagihan', {templateUrl: 'pages/master/konfigurasitagihan.html', controller: 'KonfigurasitagihanController'})
            .when('/table/siswa', {templateUrl: 'pages/table/siswa.html', controller: 'SiswaController'})
            .when('/table/kelas', {templateUrl: 'pages/table/kelas.html', controller: 'KelasController'})
            .when('/table/tahun_ajaran', {templateUrl: 'pages/table/tahun_ajaran.html', controller: 'TahunajaranController'})
            .when('/pages/master', {templateUrl: 'pages/master/paymenttransactions.html', controller: 'PaymenttransactionController'})
            .when('/report/reporttransaction', {templateUrl: 'pages/report/reporttransaction.html', controller: 'ReporttransactionController'})
            .when('/report/reportpayment', {templateUrl: 'pages/report/reportpayment.html', controller: 'ReportpaymentController'})
            .when('/about', {templateUrl: 'pages/about.html', controller: 'AboutController'})
            .otherwise({templateUrl: 'pages/404.html'});
    }])
    .config(['$httpProvider', function($httpProvider){
        var sessionTimeoutInterceptor = ['$rootScope', '$location', '$q', function($rootScope, $location, $q){
            function success(response){
                return response;
            }
            
            function error(response){
                if (response.status === 401) {
                    $location.path('/401');
                }
            }
            
            return function(promise) {
                return promise.then(success, error);
            }
        }];
        
        
        $httpProvider.responseInterceptors.push(sessionTimeoutInterceptor);
        $httpProvider.responseInterceptors.push('httpLoadingSpinner');
        var spinnerFunction = function (data, headersGetter) {
            $('#loading').show();
            return data;
        };
        $httpProvider.defaults.transformRequest.push(spinnerFunction);
    }])
    .factory('httpLoadingSpinner', function ($q, $window) {
        return function (promise) {
            return promise.then(function (response) {
                // do something on success
                $('#loading').hide();
                return response;

            }, function (response) {
                // do something on error
                $('#loading').hide();
                return $q.reject(response);
            });
        };
    })
;
