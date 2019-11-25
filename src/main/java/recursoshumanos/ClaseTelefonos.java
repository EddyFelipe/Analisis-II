/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.TelefonosJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Telefonos;
import interfaces.AccionesBasicas;
import interfaces.Filtrar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import singleton.singleton;

/**
 *
 * @author User
 */
public class ClaseTelefonos implements Filtrar, AccionesBasicas{
    public List buscarObjects(Object obj, EntityManager em, String telefono) { //Rellenar la tabla de teléfonos de un empleado
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = null;
        if (telefono.equals(""))
            lista = controlador.desplegarTelefonos((Integer)obj);
        else
            lista = controlador.filtrar(telefono, (Integer)obj);
        return lista;
    }
    
    

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        try{
            TelefonosJpaController controlador = new TelefonosJpaController(em);
            controlador.create((Telefonos)obj);
            return true; 
        }catch(Exception e){
            return false;
        }
    }
    
    public List existeTelefono(String telefono, EntityManager em)
    {
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = controlador.encontrarTelefono(telefono);
        return lista;
    }
    
    public void editarTelefono(Object obj, EntityManager em)
    {
        try {
            TelefonosJpaController controlador = new TelefonosJpaController(em);
            controlador.edit((Telefonos)obj);
        } catch (Exception ex) {
            Logger.getLogger(ClaseTelefonos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Telefonos obtenerTelefono(String telefono, EntityManager em)
    {
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = controlador.encontrarTelefono(telefono);
        return lista.get(0);
    }
    
    public void eliminarTelefono(Object obj, EntityManager em)
    {
        try {
            TelefonosJpaController controlador = new TelefonosJpaController(em);
            Telefonos telefono = (Telefonos) obj;
            controlador.destroy(telefono.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClaseTelefonos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
