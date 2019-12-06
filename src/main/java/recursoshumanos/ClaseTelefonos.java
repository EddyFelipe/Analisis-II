/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.TelefonosJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Compras;
import entidades.Empleados;
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
public class ClaseTelefonos implements AccionesBasicas{
    //Buscar teléfonos con filtro o sin este
    public List buscarObjects(Object obj, EntityManager em, String telefono) { //Rellenar la tabla de teléfonos de un empleado
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = null;
        if (telefono.equals(""))
            lista = controlador.desplegarTelefonos((Empleados)obj);
        else
            lista = controlador.filtrar(telefono, (Empleados)obj);
        return lista;
    }
    //Buscar teléfonos con filtro o sin este
    public List buscarObjectsEmpresa(Object obj, EntityManager em, String telefono) { //Rellenar la tabla de teléfonos de una empresa
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = null;
        if (telefono.equals(""))
            lista = controlador.desplegarTelefonosEmpresa((Compras)obj);
        else
            lista = controlador.filtrarEmpresa(telefono, (Compras)obj);
        return lista;
    }
    //Registrar un teléfono
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
    //Verificar que un teléfono exista
    public List existeTelefono(String telefono, EntityManager em)
    {
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = controlador.encontrarTelefono(telefono);
        return lista;
    }
    //Editar un teléfono
    public void editarTelefono(Object obj, EntityManager em)
    {
        try {
            TelefonosJpaController controlador = new TelefonosJpaController(em);
            controlador.edit((Telefonos)obj);
        } catch (Exception ex) {
            Logger.getLogger(ClaseTelefonos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Obtener un teléfono
    public Telefonos obtenerTelefono(String telefono, EntityManager em)
    {
        TelefonosJpaController controlador = new TelefonosJpaController(em);
        List<Telefonos> lista = controlador.encontrarTelefono(telefono);
        return lista.get(0);
    }
    //Eliminar un teléfono
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
}
