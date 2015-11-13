(function () {
    var app = angular.module('proyser', ['ngRoute','ProductServices']);
    
    /*app.config(function ($routeProvider) {
        $routeProvider
                .when('/alimentacion', {
                    templateUrl: 'alimentacion.html'
                })                
                .when('/transporte', {
                    templateUrl: 'transporte.html'
                })
                .when('/articulos', {
                    templateUrl: 'articulos.html'
                })
                
    });*/


    app.controller('proysercontroller', function ($scope,ProductsRestAPI) {
        
        $scope.availableProducts=[];
        
        $scope.nombre="nicolas";
        $scope.apellido="cantor";
        $scope.tipodoc = "cc";
        $scope.numDoc = 123455;
        $scope.direccion = "calle123 #123-5";
        $scope.telefono = 12345;
        $scope.correo = "niolas@hotmail.com";
        $scope.cont = "1234";
        $scope.cont1 = "1234";
        $scope.id = 1;
               
        $scope.availableProdRequestPromise=ProductsRestAPI.productsRequestPromise();
      
        $scope.availableProdRequestPromise.then(
                //promise success
                function(response){
                    console.log(response.data);                    
                    $scope.availableProducts=response.data;                    
                },
                //promise error
                function(response){
                    console.log('Unable to get data from REST API:'+response);
                }
        );       


        $scope.registrarCliente = function(){
            alert($scope.nombre);
            ProductsRestAPI.registrarCliente($scope.id,$scope.nombre,$scope.apellido,$scope.tipodoc,$scope.numDoc,$scope.direccion,$scope.telefono,$scope.correo).then(
                    //promise success
                    
                function(response){
                    console.log(response.data);                    
                    //$scope.availableProducts=response.data;  
                    alert("usuario creado correctamente");
                },
                //promise error
                function(response){
                    console.log('Unable to get data from REST API:'+response.data);
                    alert("error");
                }
            )
 
        }
        
    }
    );

})();



