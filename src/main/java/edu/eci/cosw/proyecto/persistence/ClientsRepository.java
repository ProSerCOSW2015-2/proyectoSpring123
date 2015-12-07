    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2086807
 */
public interface ClientsRepository extends CrudRepository<Cliente, Integer>{
 @Query("from Cliente c where c.correo like %:ln%")
 public List<Cliente> search(@Param("ln") String searchTerm);
 
 @Query("select c from Cliente c")
  public List<Cliente> consultarTodos();
  
  @Query("from Cliente c where c.correo like :ln")
  public Cliente buscarClienteXCorreo(@Param("ln") String searchTerm);
}
