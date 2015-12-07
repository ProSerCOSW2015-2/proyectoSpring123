/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.persistenceexercise.test;



import edu.eci.cosw.proyecto.logica.Logica;
import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.persistence.ClientsRepository;
import java.util.List;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Nicolas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextH2.xml"})
public class PersistenceFacedeTest {
    
    @Autowired
    Logica logica = new Logica();
 
    @Autowired
    private ClientsRepository cr;
 
    private static boolean springInit = false;
 
    @Before
    @Transactional
    public void setUp() throws Exception
    {
        if (!springInit)
        {
            // insert
            //Pre cargar 5 usuarios iniciales para las pruebas
            cr.save(new Cliente("jairo", "g", "cc", 123456789, "calle 170 # 64-54", 6366007, "jairo@hotmail.com", "123"));
            cr.save(new Cliente("julian", "g", "cc", 123456789, "calle 170 # 64-54", 6366007, "julian@hotmail.com", "123"));
            cr.save(new Cliente("camilo", "g", "cc", 123456789, "calle 170 # 64-54", 6366007, "fabian@hotmail.com", "123"));
            cr.save(new Cliente("nicolas", "g","cc", 123456789, "calle 170 # 64-54", 6366007, "nicolas@hotmail.com", "123"));
            springInit = true;
}

    }
    
    
   @Test
   public void testGuardarCliente (){
       //Agregag a un nuevo cliente a la base de datos

       logica.agregarCliente("rolo", "loco", "cc", 1019028392, "calle 170 #65-54", 6366007,"rolo@hotmail.com","123");

       /*logica.agregarCliente("rolo", "loco", "cc", 1019028392, "calle 170 #65-54", 6366007,"rolo@hotmail.com","123");
>>>>>>> lista de productos en transporte error en response
       assertEquals("Se a agregado un nuevo cliente a la persistencia",6, cr.count());
       
       //Si se intenta agregar a un cliente con un correo que ya existe no debe agregar nada a la base de datos
       logica.agregarCliente("rolo", "loco", "cc", 1019028392, "calle 170 #65-54", 6366007,"rolo@hotmail.com", "123");
<<<<<<< HEAD
       assertEquals("Una persona con el mismo correo no debe ser agregada",6, cr.count());
=======
       assertEquals("Una persona con el mismo correo no debe ser agregada",6, cr.count());*/

   }
}
