/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import interfaces.Filtrar;
import java.util.List;
import javax.persistence.EntityManager;
import controladores.ProductoJpaController;

/**
 *
 * @author felipe
 */
public class FiltrarProductoNombre implements Filtrar{

    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        ProductoJpaController controller = new ProductoJpaController(em);
        return controller.findFilter(obj.toString()+"%");  
    }
    
}
