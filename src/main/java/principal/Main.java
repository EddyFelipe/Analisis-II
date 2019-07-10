/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controladores.EmpleadosJpaController;
import java.util.List;
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
        //fgeneral fg = new fgeneral();
        //fg.setVisible(true);
        EmpleadosJpaController ejc = new EmpleadosJpaController(singleton.getConnection());
        List<entidades.Empleados> query = ejc.findEmpleadosEntities();
        for (entidades.Empleados emp : query) {
            System.out.println(emp);
        }
        
    }
    
}
