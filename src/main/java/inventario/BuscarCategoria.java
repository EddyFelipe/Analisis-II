/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import interfaces.Filtrar;
import java.util.List;
import javax.persistence.EntityManager;
import entidades.Categoria;
import controladores.CategoriaJpaController;
/**
 *
 * @author felipe
 */
public class BuscarCategoria implements Filtrar{

    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        CategoriaJpaController controller = new CategoriaJpaController(em);
        List<Categoria> list = controller.findCategoriaEntities();
        return list;
    }
    
}
