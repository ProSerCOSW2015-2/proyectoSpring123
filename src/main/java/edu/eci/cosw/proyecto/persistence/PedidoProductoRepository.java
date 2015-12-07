/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.PedidoProducto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author NICOLAS
 */
public interface PedidoProductoRepository extends CrudRepository<PedidoProducto, Integer>{
    
}
