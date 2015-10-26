/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.proyecto.logica;

import edu.eci.cosw.proyecto.model.Cliente;
import edu.eci.cosw.proyecto.persistence.ClientsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NICOLAS
 */
@Service
public class Logica {
    
    @Autowired
    ClientsRepository cr = new ClientsRepository() {

        @Override
        public List<Cliente> search(String searchTerm) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <S extends Cliente> S save(S s) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <S extends Cliente> Iterable<S> save(Iterable<S> itrbl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Cliente findOne(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean exists(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Iterable<Cliente> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Iterable<Cliente> findAll(Iterable<Integer> itrbl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public long count() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Cliente t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Iterable<? extends Cliente> itrbl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
   /* public void agregarCliente (String nombre, String apellido, String tDoc, int documento,String direccion, int telefono, String correo ){
        List<Cliente> clientes = cr.search("%"+correo+"%");
        if(clientes.size() <= 0){
            Cliente c = new Cliente(nombre, tDoc, documento, direccion, telefono, correo);
            cr.save(c);
        }else{
            System.out.println("El usuario ya existe, porfavor revise los datos ingresados y vlueva a intentarlo");
        }

    }*/

    public void agregarCliente(String nombre, String apellido, String tDoc, int documento,String direccion, int telefono, String correo ) {
         List<Cliente> clientes = cr.search("%"+correo+"%");
        if(clientes.size() <= 0){
            Cliente c = new Cliente(nombre, tDoc, documento, direccion, telefono, correo);
            cr.save(c);
        }else{
            System.out.println("El usuario ya existe, porfavor revise los datos ingresados y vlueva a intentarlo");
        }
    }
}
