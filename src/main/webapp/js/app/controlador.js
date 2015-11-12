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
        
        //$scope.selectedProducts=productsSelectionFactory.getData();
        
        $scope.selectedProductId=-1;

        $scope.selectedProductDetail=null;
        
        $scope.availableProdRequestPromise=ProductsRestAPI.productsRequestPromise();
        
        $scope.myVar = true;
        
        //$scope.costoTotal = ProductsRestAPI.calculateShoppingKartCost($scope.selectedProducts);
        
        /*$scope.addToSelectedProducts=function(){   
            
            //$scope.selectedProducts.push($scope.selectedProductDetail);
            productsSelectionFactory.addProduct($scope.selectedProductDetail);
            console.log('Shopping kart updated'+JSON.stringify($scope.selectedProducts));
            
        };*/
        
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

        /*$scope.setSelectedProduct=function(idprod){
            $scope.selectedProductId=idprod;
            $scope.myVar = false;
            ProductsRestAPI.productByIdRequestPromise(idprod).then(
                //promise success
                function(response){
                    console.log(response.data);                    
                    $scope.selectedProductDetail=response.data;                    
                },
                //promise error
                function(response){
                    console.log('Unable to get data from REST API:'+response);
                }
            );
            
        };       */
        
 
        
        
    }
    );

})();



