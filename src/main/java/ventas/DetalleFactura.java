
package ventas;

/**
 *
 * @author felipe
 */

/* Encapsula los detalles de un producto que se va vender */

public class DetalleFactura {
    private int cantidad;
    private double subtotal;
    private int idproducto;
    private String descripcion;
    
    public DetalleFactura(){
     cantidad = idproducto = 0;
     subtotal = 0;
     descripcion = "";
    }

    public void setCantidad(int cantidad) { this.cantidad = cantidad;  }

    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public void setIdproducto(int idproducto) { this.idproducto = idproducto; }

    public void setDescripcion(String descripcion) {  this.descripcion = descripcion;  }

    public int getCantidad() { return cantidad;  }

    public double getSubtotal() { return subtotal; }

    public int getIdproducto() { return idproducto; }

    public String getDescripcion() { return descripcion; }
    
}
