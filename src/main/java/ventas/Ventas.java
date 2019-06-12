
package ventas;

/**
 *
 * @author felipe
 */
public class Ventas {
    
    private Cliente cliente;
    private ClienteBD guardadCBD;
    private FacturaBD guardadFBD;
    private DetalleFacturaBD guardadDFBD;
    private Factura factura;
    
    public Ventas(Cliente cliente, ClienteBD guardarCBD, FacturaBD guardadFBD, DetalleFacturaBD guardarDFBD, Factura factura){
      this.cliente = cliente;
      this.guardadCBD = guardarCBD;
      this.guardadFBD = guardadFBD;
      this.guardadDFBD = guardarDFBD;
      this.factura = factura;
      
    }
    
}
