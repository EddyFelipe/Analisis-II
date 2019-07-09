/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import controladores.ProductoJpaController;
import interfaces.Filtrar;
import entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author felipe
 */
public class BuscarProducto implements Filtrar{

    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        ProductoJpaController controller = new ProductoJpaController(em);
       List<Producto> list_producto = controller.findProductoEntities();
       return list_producto;
    }
    
}
