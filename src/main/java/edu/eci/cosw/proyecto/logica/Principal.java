/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.logica;


import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.model.Proveedor;
import edu.eci.cosw.proyecto.services.SimpleFacade;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


public class Principal {
 
 public static void main(String args[]) {
 
    ApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
    Logica logica = (Logica) contexto.getBean(Logica.class);
    
   
  // logica.agregarCliente("nicolas", "apellido","cc", 12345, "hfkjshbdfl", 1234567, "nikodl@hotmail.com");
 }
 

 
}