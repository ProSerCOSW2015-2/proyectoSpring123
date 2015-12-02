(function () {
    var app = angular.module('proyser', ['ngRoute','ProductServices']);
    
    app.config(['$routeProvider',function ($routeProvider) {
        $routeProvider
                .when('/home', {
                    templateUrl: 'home.html'
                })
                .when('/registrar', {
                    templateUrl: 'registrar.html'
                })                
                .when('/transp', {
                    templateUrl: 'transporte.html'
                })
                .when('/login', {
                    templateUrl: 'login.html'
                })
                .otherwise({
               redirectTo: '/home'
            });  
    }]);


    app.controller('proysercontroller', function ($scope,ProductsRestAPI, $location) {
        
        
        
        $scope.availableProducts=[];
        $scope.usuario = {"corre": "", "clave": ""};

        $scope.transporteProveedor=[];
        $scope.infoLogin=[];
        $scope.proveedor;
        $scope.menuState = {}
        $scope.menuState.show = false;
        $scope.nombreProveedor = "";
        
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

        
        $scope.consultarTransProductos = function(id ,nombreP){
            $scope.menuState.show = !$scope.menuState.show;
            $scope.nombreProveedor = nombreP;
            ProductsRestAPI.productosProveedorTransporteSeleccionado(id).then(
                                //promise success                        
                            function(response){
                                $scope.menuState.show = !$scope.menuState.show;
                                $scope.transporteProveedor=response.data;                               
                                console.log(response.data);                          
                            },
                            //promise error
                            function(response){
                                $scope.menuState.show = !$scope.menuState.show;
                                console.log('Unable to get data from REST API:'+ response.data);
                                alert("No se ha podido consultar, por favor revise sus datos.");
                            }
                        )
        }
        
            $scope.login = function(correo, contra){
            $scope.usuario.corre =  correo.split(".");
            $scope.usuario.clave =  contra;
            ProductsRestAPI.loginUsuario($scope.usuario.corre).then(
                                //promise success                        
                            function(response){
                                $scope.infoLogin = response.data;
                               if($scope.infoLogin.length == 0){
                                   alert("Nombre de usuario o contraseña invalidos");
                               }
                                if($scope.infoLogin == correo){
                                    alert("usuario correcto");
                                }                          
                            },
                            //promise error
                            function(response){
                                alert("No se ha podido consultar, por favor revise sus datos.");
                            }
                        )
        }

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
                            $location.url("/transp");
                        },
                        //promise error
                        function(response){
                            console.log('Unable to get data from REST API:'+response.data);
                            alert("No se ha podido guardar la información, por favor revise sus datos.");
                        }
                    )
                }
    
            }
 
        }
        
    }
    );

})();



