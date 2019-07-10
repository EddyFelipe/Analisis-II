/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.*;
import controladores.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //try {
            // TODO code application logic here
          fgeneral fg = new fgeneral();
            fg.setVisible(true);
            
            
            
            /*ProductoJpaController controller = new ProductoJpaController(singleton.singleton.getConnection());
            Producto pr = new Producto(2, 1);
            pr.setCantidad(46);
            pr.setNombre("tamaño 2");
            pr.setPrecioVenta((float)4);
            controller.edit(pr);
            System.out.println("Modificacion exitosa");*/
            //Producto prd = controller.findProducto(new ProductoPK(1,1));
            /*ClienteJpaController controller = new ClienteJpaController(singleton.singleton.getConnection());
            System.out.println(controller.findMaxid());*/
       /* } catch (Exception ex) {
            System.out.println("Fallo en la madificacion");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
