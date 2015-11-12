/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.services;


import edu.eci.cosw.proyecto.logica.Logica;
import edu.eci.cosw.proyecto.model.Proveedor;
import edu.eci.cosw.proyecto.persistence.ProveedorRepository;
import java.sql.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class SimpleFacade {
    
    private static final Map<Integer,Proveedor> dummyProductsDataMap=new Hashtable<>();
    
     //static Logica logica = new Logica();
    
    
    
    public List<Proveedor> getAllProvedores(){
        
        return new LinkedList(dummyProductsDataMap.values());
    } 
    
}
