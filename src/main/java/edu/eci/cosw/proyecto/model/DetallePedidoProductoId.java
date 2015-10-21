package edu.eci.cosw.proyecto.model;
// Generated 20/10/2015 07:04:08 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DetallePedidoProductoId generated by hbm2java
 */
@Embeddable
public class DetallePedidoProductoId  implements java.io.Serializable {


     private int pedidoIdpedido;
     private int productoIdProducto;

    public DetallePedidoProductoId() {
    }

    public DetallePedidoProductoId(int pedidoIdpedido, int productoIdProducto) {
       this.pedidoIdpedido = pedidoIdpedido;
       this.productoIdProducto = productoIdProducto;
    }
   


    @Column(name="Pedido_IDPEDIDO", nullable=false)
    public int getPedidoIdpedido() {
        return this.pedidoIdpedido;
    }
    
    public void setPedidoIdpedido(int pedidoIdpedido) {
        this.pedidoIdpedido = pedidoIdpedido;
    }


    @Column(name="Producto_idProducto", nullable=false)
    public int getProductoIdProducto() {
        return this.productoIdProducto;
    }
    
    public void setProductoIdProducto(int productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetallePedidoProductoId) ) return false;
		 DetallePedidoProductoId castOther = ( DetallePedidoProductoId ) other; 
         
		 return (this.getPedidoIdpedido()==castOther.getPedidoIdpedido())
 && (this.getProductoIdProducto()==castOther.getProductoIdProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPedidoIdpedido();
         result = 37 * result + this.getProductoIdProducto();
         return result;
   }   


}

