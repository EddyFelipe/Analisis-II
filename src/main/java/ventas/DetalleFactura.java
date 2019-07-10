package ventas;

/**
 *
 * @author felipe
 */
public interface DetalleFactura {
    
    public void registart(Object detalle);
    public void modificar(Object detall, int index);
    public boolean eliminar(int index);
    
}
