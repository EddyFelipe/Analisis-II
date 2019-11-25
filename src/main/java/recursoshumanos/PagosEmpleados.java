/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import interfaces.AccionesBasicas;
import javax.persistence.EntityManager;

/**
 *
 * @author User
 */
public class PagosEmpleados implements AccionesBasicas {

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        return true;
    }
    
}
