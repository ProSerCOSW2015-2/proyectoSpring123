/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.persistence;

import edu.eci.cosw.proyecto.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2086807
 */
public interface ProductRepository extends CrudRepository<Producto, Integer>{

    @Query("from Transporte t where t.proveedor.idProveedor like :ln")
    public List<Producto> buscarProductos(@Param("ln") int searchTerm);
    
    @Query("select p from Producto p join p.proveedors pp where pp.idProveedor like :ln")
    public List<Producto> buscarArticulo(@Param("ln") int searchTerm);

}
