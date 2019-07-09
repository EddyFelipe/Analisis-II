package inventario;

import interfaces.*;
import controladores.ProductoJpaController;
import entidades.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class Inventario implements AccionesBasicas{
    

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        
        try {
             ProductoJpaController controller = new ProductoJpaController(em);
             controller.create((Producto)obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public DefaultTableModel listProducto(Object obj,EntityManager em){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("cantidad");
        model.addColumn("precio venta");
        BuscarProducto bproducto = new BuscarProducto();
        List<Producto> list = bproducto.buscarObjects(obj, em);
        for( Producto producto : list){
           model.addRow(new Object[]{producto.getNombre(), producto.getCantidad(), producto.getPrecioVenta()});
        }      
        return model;
    
    }
    
    public DefaultComboBoxModel listCategoria(Object obj, EntityManager em){
           DefaultComboBoxModel modelcombo = new DefaultComboBoxModel();
           
           BuscarCategoria bcategoria = new BuscarCategoria();
           List<Categoria> listcategoria = bcategoria.buscarObjects(obj, em);
           
           for(Categoria categori : listcategoria){
               modelcombo.addElement(categori.getCategoria());
           }
           return modelcombo;
    }
    
}
