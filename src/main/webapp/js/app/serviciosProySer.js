(function () {
    var app = angular.module('ProductServices', []);

    app.service('ProductsRestAPI', function ($http) {
        
        this.productsRequestPromise = function () {            
            return $http({
                method: 'GET',
                url: 'rest/products/transporte'
            });            
        };
        
        this.articuloRequestPromise = function () {            
            return $http({
                method: 'GET',
                url: 'rest/products/articulo'
            });            
        };
        
     
        this.productosProveedorTransporteSeleccionado = function (id) {            
            return $http({
                method: 'GET',
                url: 'rest/products/producto/'+id
            });            
        };
        
        this.productosProveedorArticuloSeleccionado = function (id) {            
            return $http({
                method: 'GET',
                url: 'rest/products/articulos/'+id
            });            
        };
        
         this.loginUsuario = function (correo) {            
            return $http({
                method: 'GET',
                url: 'rest/cliente/login/'+correo
            });            
        };
            

        this.registrarCliente = function (id,nombre,apellido,tipodoc,numDoc,direccion,telefono,correo,contra) {  
           var usuario = {"idcliente":id,"nombre":nombre,"apellido":apellido,"tipoDoc":tipodoc,"numDoc":numDoc,"direccion":direccion,"telefono":telefono,"correo":correo,"contrasena":contra,"pedidoProductos":null,"pedidoTransportes":null};
            return $http({
                method: 'POST',
                url: 'rest/cliente/guardar',
                data: usuario
                                
            });            
        }; 
        
        this.registrarTransaccion = function (idCliente, idTransporte) {
            var a =[idCliente, idTransporte];
            
            return $http({
                method: 'POST',
                url: 'rest/transacciones/guardar',
                data: a                        
            });            
        };
        
         this.registrarTransaccionProducto = function (idCliente) {
            var a =idCliente;
            
            return $http({
                method: 'POST',
                url: 'rest/transacciones/guardarProducto/',
                data: a                      
            });            
        };
        
    });

})();






