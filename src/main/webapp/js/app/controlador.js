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
        
        $scope.nombre="";
        $scope.apellido="";
        $scope.numDoc;
        $scope.direccion = "";
        $scope.telefono;
        $scope.correo = "";
        $scope.contra = "";
        $scope.contra1 = "";
        $scope.id = 1;
        $scope.operators = 
	{   
		"value": "C.C", 
		"values": ["C.C", "C.E", "Pasaporte"] 
	};
        $scope.myOptions;
               
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
                if($scope.contra != $scope.contra1){
                    alert("Las contraseñas no coinciden");
                }else{
                    ProductsRestAPI.registrarCliente($scope.id,$scope.nombre,$scope.apellido,$scope.operators.value,$scope.numDoc,$scope.direccion,$scope.telefono,$scope.correo, $scope.contra).then(
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
        
    }
    );

})();



