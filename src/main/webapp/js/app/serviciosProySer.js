(function () {
    var app = angular.module('ProductServices', []);

    app.service('ProductsRestAPI', function ($http) {
        
        this.productsRequestPromise = function () {            
            return $http({
                method: 'GET',
                url: 'rest/products/proveedor'
            });            
        };
    
        this.registrarCliente = function (id,nombre,apellido,tipodoc,numDoc,direccion,telefono,correo,contra) {  
           var usuario = {"idcliente":id,"nombre":nombre,"apellido":apellido,"tipoDoc":tipodoc,"numDoc":numDoc,"direccion":direccion,"telefono":telefono,"correo":correo,"contraseña":contra,"pedidoProductos":null,"pedidoTransportes":null};
            return $http({
                method: 'POST',
                url: 'rest/cliente/guardar',
                data: usuario
                                
            });            
        };   
//idcliente":1
    });

})();






