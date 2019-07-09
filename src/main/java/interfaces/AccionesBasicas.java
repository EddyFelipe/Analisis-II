/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author felipe
 */
public interface AccionesBasicas {
    
    public boolean registrarObject(Object obj, EntityManager em);
    
}
