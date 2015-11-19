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
            if($scope.nombre.length <= 0|| $scope.apellido.length <= 0 || $scope.numDoc <= 0 || $scope.direccion.length <= 0 || $scope.telefono <= 0 || $scope.correo.length <= 0 || $scope.contra.length <= 0 || $scope.contra1.length <= 0){
                alert("Ningun campo puede estar bacio");
                if($scope.nombre.length <= 0){document.getElementById('name').style.border= '2px solid #E60000';}
                if($scope.apellido.length <= 0){document.getElementById('apellido').style.border= '2px solid #E60000';}
                if($scope.numDoc <= 0 || $scope.numDoc == undefined){document.getElementById('numDoc').style.border= '2px solid #E60000';}
                if($scope.direccion.length <= 0){document.getElementById('direccion').style.border= '2px solid #E60000';}
                if($scope.telefono <= 0 || $scope.telefono == undefined){document.getElementById('tel').style.border= '2px solid #E60000';}
                if($scope.correo.length <= 0){document.getElementById('email').style.border= '2px solid #E60000';}
                if($scope.contra.length <= 0){document.getElementById('pass').style.border= '2px solid #E60000';}
                if($scope.contra1.length <= 0){document.getElementById('repass').style.border= '2px solid #E60000';}
                
            }else{               
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
                            alert("No se ha podido guardar le información, por favor revise sus datos.");
                        }
                    )
                }
    
            }
 
        }
        
    }
    );

})();



