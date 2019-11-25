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
import singleton.singleton;
import recursoshumanos.ClaseTelefonos;

/**
 *
 * @author felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          System.getProperty("java.classpath");
          Login login = new Login();
          login.setVisible(true);
          //fgeneral fg = new fgeneral();
          //fg.setVisible(true);
    }
    
}
