package ventas;

/**
 *
 * @author felipe
 */
public interface DetalleFactura {
    
    public void registart(DetalleFactura detalle);
    public void modificar(DetalleFactura detall, int index);
    public boolean eliminar(int index);
    
}
