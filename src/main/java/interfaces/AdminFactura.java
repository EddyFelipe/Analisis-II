package interfaces;

import ventas.DetalleFactura;

/**
 *
 * @author felipe
 */
public interface AdminFactura {
    
    public void registrarDetalle(DetalleFactura detalle);
    public void modificarDetalle(int index);
    public void eliminarDetalle(int index);
    
}
