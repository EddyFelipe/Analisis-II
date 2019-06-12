package ventas;

/**
 *
 * @author felipe
 */
public interface AdminFactura {
    
    public void registrarDetalle(DetalleFactura detalle);
    public void modificarDetalle(int index);
    public void eliminarDetalle(int index);
    
}
