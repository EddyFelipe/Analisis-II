package inventario;

import interfaces.AccionesBasicas;
import controladores.ProductoJpaController;
import javax.persistence.EntityManager;

/**
 *
 * @author felipe
 */
public class Inventario implements AccionesBasicas{
    

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        
        ProductoJpaController pdcontroller = new ProductoJpaController(em);
        
       return false;
    }
    
}
