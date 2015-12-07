/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.Transaccion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author NICOLAS
 */
public interface TransaccionRepository extends CrudRepository<Transaccion, Integer>{
    
  @Query("select t from Transaccion t")
  public List<Transaccion> consultarTodos();
}
