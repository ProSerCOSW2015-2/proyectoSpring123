/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.controllers;

import edu.eci.cosw.proyecto.logica.Logica;
import edu.eci.cosw.proyecto.model.Producto;
import edu.eci.cosw.proyecto.model.Transaccion;
import java.util.ArrayList;
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
 * @author NICOLAS
 */

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    
     
    @Autowired
    Logica logica;
    
    @RequestMapping(value="/check",method = RequestMethod.GET)        
    public String check() {
        return "Servidor Rest transaccion corriendo";        
    }
    
    @RequestMapping(value="/tran",method = RequestMethod.GET)        
    public List<Transaccion> consultarTransaccion() {  
        return logica.consultarTransaccion();
    }
    
     @RequestMapping(value="/guardar",method = RequestMethod.POST)
    public ResponseEntity<?> registrarTransaccionTransporte(@RequestBody int[] id ){
        logica.guardarTransaccion(id[0], id[1]);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }   
    
    @RequestMapping(value="/guardarProducto",method = RequestMethod.POST)
    public ResponseEntity<?> registrarTransaccionProducto(@RequestBody int idCliente){
        logica.guardarTransaccionProducto(idCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }   
    
  
    
}
