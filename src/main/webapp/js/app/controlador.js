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
                .when('/articulo', {
                    templateUrl: 'articulos.html'
                })
                .when('/login', {
                    templateUrl: 'login.html',
                    controller: "proysercontroller"
                })
                .when('/pasarela', {
                    templateUrl: 'pasarela_dePago.html',
                    controller: "contPasarela"
                })
                .otherwise({
               redirectTo: '/home'
            });  
    }]);



    app.factory("controlVariables", function(){
        var correo = 0;
        var nombreN = ""; 
        var carrito = [];

        var interfaz = {
            getUsuario: function(){
                return correo;
            },
            setUsuario: function(nombre){
                correo = 1;
                nombreN = nombre;
            },
            getCarrito: function(){
              return carrito;  
            },
            resetCarrito: function(){
              carrito = [];  
            },
            setTransporte: function(nombre, proveedor, precio){
                tipoN = nombre;
                proveedorN = proveedor;
                montoValor = precio;
            },
            setCarritoArticulos: function(nombre, proveedor, precio){
                var info = { "nombre" : nombre,
                              "proveedor" : proveedor,
                              "precio" : precio
                            };
                carrito.push(info);
            }
            
        }
        return interfaz;
    });

    app.controller('proysercontroller', function ($scope,ProductsRestAPI,$location, controlVariables) {
        
        
        
        $scope.availableProducts=[];
        $scope.availableArticulos=[];
        $scope.usuario = {"corre": "", "clave": ""};

        $scope.transporteProveedor=[];
        $scope.articuloProveedor=[];
        $scope.infoLogin=[];
        
        $scope.nombreUsuario = "";
        
        $scope.menuState = {};
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

        $scope.availableArtRequestPromise=ProductsRestAPI.articuloRequestPromise();
      
        $scope.availableArtRequestPromise.then(
                //promise success
                function(response){
                    console.log(response.data);                    
                    $scope.availableArticulos=response.data;                    
                },
                //promise error
                function(response){
                    console.log('Unable to get data from REST API:'+response);
                }
        ); 
        
        $scope.valores = function(nombre, proveedor, precio){
            //controlVariables.resetCarrito();
            controlVariables.setCarritoArticulos(nombre, proveedor, precio);
            if(controlVariables.getUsuario() === 1){
                $location.url("/pasarela");
            }else{
                $location.url("/login");
            }
            
        };
        
         $scope.nextArticulos = function(){
            //controlVariables.resetCarrito();
            if(controlVariables.getUsuario() === 1){
                $location.url("/pasarela");
            }else{
                $location.url("/login");
            }
            
        };
        
        $scope.carritoArticulos = function(nombre, proveedor, precio){
            controlVariables.setCarritoArticulos(nombre, proveedor, precio);
            alert("Articulo adicionado");
        };

        $scope.entrar = function(correo, contra){
            $scope.usuario.corre =  correo.split(".");
            $scope.usuario.clave =  contra;;
            ProductsRestAPI.loginUsuario($scope.usuario.corre).then(
                                //promise success                        
                            function(response){
                                  $scope.infoLogin = response.data;
                               if($scope.infoLogin.length === 0){
                                   alert("Nombre de usuario o contraseña invalidos");
                               }else{
                                   if(response.data.contrasena === contra){
                                        alert("Bienvenido " + response.data.nombre);
                                        controlVariables.setUsuario(response.data.nombre);
                                        $scope.nombreUsuario = "Bienvenido " + response.data.nombre;
                                        $location.url("/pasarela");
                                    }else{
                                        alert("Usuario o Contraseña invalidos");
                                    }
                               }
                                                         
                            },
                            //promise error
                            function(response){
                                alert("No se ha podido consultar, por favor revise sus datos.");
                            }
                        );
        };
        
        

        
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
                        );
        };
        
        
         $scope.consultarArticulos = function(id ,nombreP){
            $scope.menuState.show = !$scope.menuState.show;
            $scope.nombreProveedor = nombreP;
            ProductsRestAPI.productosProveedorArticuloSeleccionado(id).then(
                            //promise success                        
                            function(response){
                                $scope.menuState.show = !$scope.menuState.show;
                                $scope.articuloProveedor=response.data;                               
                                console.log(response.data);                          
                            },
                            //promise error
                            function(response){
                                $scope.menuState.show = !$scope.menuState.show;
                                console.log('Unable to get data from REST API:'+ response.data);
                                alert("En este momento no se encuentran los productos disponibles.");
                            }
                        );
        };
              

        $scope.registrarCliente = function(){
            if($scope.nombre.length <= 0|| $scope.apellido.length <= 0 || $scope.numDoc <= 0 || $scope.direccion.length <= 0 || $scope.telefono <= 0 || $scope.correo.length <= 0 || $scope.contra.length <= 0 || $scope.contra1.length <= 0){
                alert("Ningun campo puede estar bacio");
                if($scope.nombre.length <= 0){document.getElementById('name').style.border= '2px solid #E60000';}
                if($scope.apellido.length <= 0){document.getElementById('apellido').style.border= '2px solid #E60000';}
                if($scope.numDoc <= 0 || $scope.numDoc === undefined){document.getElementById('numDoc').style.border= '2px solid #E60000';}
                if($scope.direccion.length <= 0){document.getElementById('direccion').style.border= '2px solid #E60000';}
                if($scope.telefono <= 0 || $scope.telefono === undefined){document.getElementById('tel').style.border= '2px solid #E60000';}
                if($scope.correo.length <= 0){document.getElementById('email').style.border= '2px solid #E60000';}
                if($scope.contra.length <= 0){document.getElementById('pass').style.border= '2px solid #E60000';}
                if($scope.contra1.length <= 0){document.getElementById('repass').style.border= '2px solid #E60000';}
                
            }else{               
                if($scope.contra !== $scope.contra1){
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
                    );
                }
    
            }
 
        };
        
    }
    );
    


 app.controller('contPasarela', function ($scope,ProductsRestAPI,$location, controlVariables) {
        
    //variable de compra de transporte
        $scope.carrito = [];
        $scope.carrito = controlVariables.getCarrito();
        
        
                 
});
    


})();



