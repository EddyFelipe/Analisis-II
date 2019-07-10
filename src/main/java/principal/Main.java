/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controladores.EmpleadosJpaController;
import entidades.Empleados;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import singleton.singleton;

/**
 *
 * @author felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fgeneral fg = new fgeneral();
        fg.setVisible(true);
        //EmpleadosJpaController ejc = new EmpleadosJpaController(singleton.getConnection());
        //Empleados empleado = new Empleados();
        //empleado.setId(3);
        //empleado.setNombre("Byron");
        //empleado.setApellido("Rosales");
        //try {
          //  ejc.edit(empleado);
            //List<entidades.Empleados> query = ejc.findEmpleadosEntities();
            //for (entidades.Empleados emp : query) {
            //    System.out.println(emp);
            // }
        //} catch (Exception ex) {
          //  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        //}
        
    }
    
}
