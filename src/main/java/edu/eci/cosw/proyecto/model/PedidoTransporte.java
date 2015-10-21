package edu.eci.cosw.proyecto.model;
// Generated 16/10/2015 07:04:08 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PedidoTransporte generated by hbm2java
 */
@Entity
@Table(name="Pedido_Transporte"
)
public class PedidoTransporte  implements java.io.Serializable {


     private Integer idpedido;
     private Cliente cliente;
     private Transaccion transaccion;
     private Transporte transporte;
     private Date fecha;

    public PedidoTransporte() {
    }

    public PedidoTransporte(Cliente cliente, Transaccion transaccion, Transporte transporte, Date fecha) {
       this.cliente = cliente;
       this.transaccion = transaccion;
       this.transporte = transporte;
       this.fecha = fecha;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDPEDIDO", unique=true, nullable=false)
    public Integer getIdpedido() {
        return this.idpedido;
    }
    
    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Cliente_IDCLIENTE")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Transaccion_idTransaccion")
    public Transaccion getTransaccion() {
        return this.transaccion;
    }
    
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Transporte_idTransporte")
    public Transporte getTransporte() {
        return this.transporte;
    }
    
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FECHA", length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


