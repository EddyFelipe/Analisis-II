
package ventas;

import interfaces.AdminFactura;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Factura implements AdminFactura{
    
    private double total;
    private ArrayList<AdminFactura> detalles;
    private double descuento;
    
    public Factura(){}
    
    /* Propiedades generales de la factura */

    public double getTotal() {  return total;  }

    public ArrayList<AdminFactura> getDetalles() { return detalles; }

    public double getDescuento() {  return descuento;  }

    public void setDescuento(double descuento) {  this.descuento = descuento;  }
   

    @Override
    public void registrarDetalle(DetalleFactura detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarDetalle(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarDetalle(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
