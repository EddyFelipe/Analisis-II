package ventas;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public interface GuardarDetalleFactura {
    
    public void registrarDetalle(ArrayList<AdminFactura> detalles, int idFactura);
}
