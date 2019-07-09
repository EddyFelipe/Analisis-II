/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import interfaces.*;
import entidades.*;
import controladores.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author felipe
 */
public class Ventas  implements AccionesBasicas{


    

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        try {
            ClienteJpaController controllercliente = new ClienteJpaController(em);
            controllercliente.create((Cliente)obj);
            TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findLastid",Cliente.class);
            System.out.println("ID INSERTADO: ");
            return true;
        } catch (Exception ex) {            
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
