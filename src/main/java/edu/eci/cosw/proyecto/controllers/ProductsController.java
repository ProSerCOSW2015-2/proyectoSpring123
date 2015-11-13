/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.controllers;

import edu.eci.cosw.proyecto.logica.Logica;
import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.model.Producto;
import edu.eci.cosw.proyecto.model.Proveedor;
import edu.eci.cosw.proyecto.services.SimpleFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    Logica logica;
    
    
    /**
     * 
     * @return prueba rest api
     */
    @RequestMapping(value="/check",method = RequestMethod.GET)        
    public String check() {
        return "Servidor Rest corriendo";        
    }
      
    /**
     * 
     * @return lista con todos los proveedores
     */
    @RequestMapping(value="/proveedor",method = RequestMethod.GET)        
    public List<Proveedor> consultarProveedores() {  
        return logica.consultarProveedores();
    }
    
        
    
}

