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
            cr.save(new Cliente("jairo", "cc", 123456789, "calle 170 # 64-54", 6366007, "jairo@hotmail.com"));
            cr.save(new Cliente("julian", "cc", 123456789, "calle 170 # 64-54", 6366007, "julian@hotmail.com"));
            cr.save(new Cliente("camilo", "cc", 123456789, "calle 170 # 64-54", 6366007, "camilo@hotmail.com"));
            cr.save(new Cliente("fabian", "cc", 123456789, "calle 170 # 64-54", 6366007, "fabian@hotmail.com"));
            cr.save(new Cliente("nicolas", "cc", 123456789, "calle 170 # 64-54", 6366007, "nicolas@hotmail.com"));
            springInit = true;
        }
    }
    
    
   @Test
   public void testGuardarCliente (){
       //Agregag a un nuevo cliente a la base de datos
       logica.agregarCliente("rolo", "loco", "cc", 1019028392, "calle 170 #65-54", 6366007,"rolo@hotmail.com");
       assertEquals("Se a agregado un nuevo cliente a la persistencia",6, cr.count());
       
       //Si se intenta agregar a un cliente con un correo que ya existe no debe agregar nada a la base de datos
       logica.agregarCliente("rolo", "loco", "cc", 1019028392, "calle 170 #65-54", 6366007,"rolo@hotmail.com");
       assertEquals("Una persona con el mismo correo no debe ser agregada",6, cr.count());
   }
}