(function () {
    var app = angular.module('ShoppingKart', ['ngRoute','ProductServices']);
    
    app.factory('productsSelectionFactory', function () {
        var data = {
            prodselection: []
        };
        return {
            getData: function () {
            return data.prodselection;
            },
            addProduct: function (product) {
                data.prodselection.push(product);
            }
        };
    });

    app.config(function ($routeProvider) {
        $routeProvider
                .when('/registrar', {
                    templateUrl: 'registrar.html'
                })                
                .when('/producto', {
                    templateUrl: 'producto.html'
                })
                .when('/transporte', {
                    templateUrl: 'transporte.html'
                })
                .when('/home', {
                    templateUrl: 'home.html'                 
                });
    });


    app.controller('skcontroller', function ($scope,ProductsRestAPI, productsSelectionFactory) {
        
        /*$scope.availableProducts=[];
        
        $scope.selectedProducts=productsSelectionFactory.getData();
        
        $scope.selectedProductId=-1;

        $scope.selectedProductDetail=null;
        
        $scope.availableProdRequestPromise=ProductsRestAPI.productsRequestPromise();
        
        $scope.myVar = true;
        
        $scope.costoTotal = ProductsRestAPI.calculateShoppingKartCost($scope.selectedProducts);
        
        $scope.addToSelectedProducts=function(){   
            
            //$scope.selectedProducts.push($scope.selectedProductDetail);
            productsSelectionFactory.addProduct($scope.selectedProductDetail);
            console.log('Shopping kart updated'+JSON.stringify($scope.selectedProducts));
            
        };
        
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

        $scope.setSelectedProduct=function(idprod){
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


