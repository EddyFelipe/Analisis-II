
package ventas;

/**
 *
 * @author felipe
 */
public class Cliente {
    
    private String nombre;
    private String direccion;
    private String nit;
    private int idcliente;
    private static Cliente cliente = null;
    
    private Cliente(){
      nombre = direccion = nit = "";
      idcliente = 0;
    }
    
    public Cliente nuevoCliente(){
        
      if( cliente == null)
          cliente = new Cliente();
      
      return cliente;
    }

    public void setNombre(String nombre) {  this.nombre = nombre;  }

    public void setDireccion(String direccion) { this.direccion = direccion;  }

    public void setNit(String nit) {  this.nit = nit; }

    public void setIdcliente(int idcliente) { this.idcliente = idcliente;  }

    public String getNombre() { return nombre; }

    public String getDireccion() {  return direccion;  }

    public String getNit() {  return nit;   }

    public int getIdcliente() { return idcliente; }
    
    public void inicializar(){
      nombre = direccion = nit = "";
      idcliente = 0;
    }
    
}
