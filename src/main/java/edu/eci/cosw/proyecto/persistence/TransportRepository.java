/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.model.Transporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2086807
 */
public interface TransportRepository extends CrudRepository<Transporte, Integer>{
    
 @Query("from Transporte c where c.idTransporte like :ln")
 public Transporte buscarTransPorId(@Param("ln") int searchTerm);
}
