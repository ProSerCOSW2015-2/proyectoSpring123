/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.model.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NICOLAS
 */
public interface ProveedorRepository extends CrudRepository<Proveedor, Integer>{
/* @Query("from Proveedor p where p.idProveedor like :ln")
 public Proveedor search(@Param("ln") int searchTerm);*/
    
    //select p from Proveedor p where p.tipo = 2
 
  @Query("select p from Proveedor p")
  public List<Proveedor> consultarTodos();
  
  @Query("from Proveedor p where p.tipo like :ln")
 public List<Proveedor> consultarProveedorTransporte(@Param("ln") int searchTerm);
 
 @Query("from Proveedor p where p.tipo like :ln")
 public List<Proveedor> consultarProveedorArticulo(@Param("ln") int searchTerm);
}
