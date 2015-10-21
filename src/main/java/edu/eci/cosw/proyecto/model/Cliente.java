package edu.eci.cosw.proyecto.model;
// Generated 16/10/2015 07:04:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="Cliente"
    , uniqueConstraints = @UniqueConstraint(columnNames="CORREO") 
)
public class Cliente  implements java.io.Serializable {


     private Integer idcliente;
     private String nombre;
     private String apellido;
     private String tipoDoc;
     private int numDoc;
     private String direccion;
     private int telefono;
     private String correo;
     private Set<PedidoProducto> pedidoProductos = new HashSet<PedidoProducto>(0);
     private Set<PedidoTransporte> pedidoTransportes = new HashSet<PedidoTransporte>(0);

    public Cliente() {
    }

	
    public Cliente(String nombre, String tipoDoc, int numDoc, String direccion, int telefono, String correo) {
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Cliente(String nombre, String apellido, String tipoDoc, int numDoc, String direccion, int telefono, String correo, Set<PedidoProducto> pedidoProductos, Set<PedidoTransporte> pedidoTransportes) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.tipoDoc = tipoDoc;
       this.numDoc = numDoc;
       this.direccion = direccion;
       this.telefono = telefono;
       this.correo = correo;
       this.pedidoProductos = pedidoProductos;
       this.pedidoTransportes = pedidoTransportes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDCLIENTE", unique=true, nullable=false)
    public Integer getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    
    @Column(name="NOMBRE", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="APELLIDO", length=45)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="TIPO_DOC", nullable=false, length=3)
    public String getTipoDoc() {
        return this.tipoDoc;
    }
    
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    
    @Column(name="NUM_DOC", nullable=false)
    public int getNumDoc() {
        return this.numDoc;
    }
    
    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    
    @Column(name="DIRECCION", nullable=false, length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="TELEFONO", nullable=false)
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="CORREO", unique=true, nullable=false, length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<PedidoProducto> getPedidoProductos() {
        return this.pedidoProductos;
    }
    
    public void setPedidoProductos(Set<PedidoProducto> pedidoProductos) {
        this.pedidoProductos = pedidoProductos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<PedidoTransporte> getPedidoTransportes() {
        return this.pedidoTransportes;
    }
    
    public void setPedidoTransportes(Set<PedidoTransporte> pedidoTransportes) {
        this.pedidoTransportes = pedidoTransportes;
    }




}

