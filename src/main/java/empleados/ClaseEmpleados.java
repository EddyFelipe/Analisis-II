/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

import controladores.EmpleadosJpaController;
import interfaces.Filtrar;
import java.util.List;
import entidades.*;
import singleton.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import entidades.*;
import interfaces.AccionesBasicas;

/**
 *
 * @author igeni
 */
public class ClaseEmpleados implements Filtrar, AccionesBasicas{

    @Override
    public List buscarObjects(Object obj) {
        EntityManager em = singleton.getConnection();
        EmpleadosJpaController ContEmpleados = new EmpleadosJpaController(em);
        List<Empleados> lista = null;
       if (String.valueOf(obj).equals(""))
        {
            Object O[] = null;
            lista = ContEmpleados.findEmpleadosEntities();
        }
        else
        {
            lista = ContEmpleados.filtrar(String.valueOf(obj));
        }
        return lista;
    }

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        try{
           EmpleadosJpaController controlador = new EmpleadosJpaController(em);
            controlador.create((Empleados)obj);
            return true; 
        }catch(Exception e){
            return false;
        }
        
    }

    @Override
    public boolean editarObject(Object obj, EntityManager em, int id) {
        try{
            EmpleadosJpaController controlador = new EmpleadosJpaController(em);
            controlador.edit((Empleados)obj);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean eliminarObject(Object obj, EntityManager em, int id) {
        try{
            EmpleadosJpaController controlador = new EmpleadosJpaController(em);
            controlador.edit((Empleados)obj);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
}
