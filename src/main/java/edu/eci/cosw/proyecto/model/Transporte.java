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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Transporte generated by hbm2java
 */
@Entity
@Table(name="Transporte"
)
public class Transporte  implements java.io.Serializable {


     private Integer idTransporte;
     private Evaluacion evaluacion;
     private Proveedor proveedor;
     private String tipo;
     private String placa;
     private int precio;
     private Set<PedidoTransporte> pedidoTransportes = new HashSet<PedidoTransporte>(0);

    public Transporte() {
    }

	
    public Transporte(Evaluacion evaluacion, Proveedor proveedor, String tipo, String placa, int precio) {
        this.evaluacion = evaluacion;
        this.proveedor = proveedor;
        this.tipo = tipo;
        this.placa = placa;
        this.precio = precio;
    }
    public Transporte(Evaluacion evaluacion, Proveedor proveedor, String tipo, String placa, int precio, Set<PedidoTransporte> pedidoTransportes) {
       this.evaluacion = evaluacion;
       this.proveedor = proveedor;
       this.tipo = tipo;
       this.placa = placa;
       this.precio = precio;
       this.pedidoTransportes = pedidoTransportes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idTransporte", unique=true, nullable=false)
    public Integer getIdTransporte() {
        return this.idTransporte;
    }
    
    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Evaluacion_idEvaluacion", nullable=false)
    public Evaluacion getEvaluacion() {
        return this.evaluacion;
    }
    
    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Proveedor_idProveedor", nullable=false)
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
    @Column(name="tipo", nullable=false, length=15)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="placa", nullable=false, length=6)
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    @Column(name="precio", nullable=false)
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="transporte")
    public Set<PedidoTransporte> getPedidoTransportes() {
        return this.pedidoTransportes;
    }
    
    public void setPedidoTransportes(Set<PedidoTransporte> pedidoTransportes) {
        this.pedidoTransportes = pedidoTransportes;
    }




}

