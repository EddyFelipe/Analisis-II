/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.EmpleadosJpaController;
import controladores.TelefonosJpaController;
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
    //Registrar a un empleado
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
    //Editar los datos de un empleado
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
    //Buscar a los empleados con filtro o sin este
    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        EmpleadosJpaController ContEmpleados = new EmpleadosJpaController(em);
        List<Empleados> lista = null;
        if (String.valueOf(obj).equals(""))
            lista = ContEmpleados.findEmpleadosEntities();
        else
            lista = ContEmpleados.filtrar(String.valueOf(obj));
        return lista;
    }
    //Obtener a un empleado
    public Empleados obtenerEmpleado(EntityManager em, int idEmpleado)
    {
        EmpleadosJpaController controlador = new EmpleadosJpaController(em);
        return controlador.findEmpleados(idEmpleado);
    }
    //Buscar si un usuario ya existe
    public Empleados buscarUsuario(EntityManager em, String usuario) { //Rellenar la tabla de teléfonos de un empleado
        EmpleadosJpaController controlador = new EmpleadosJpaController(em);
        List<Empleados> lista = null;
        lista = controlador.encontrarUsuario(usuario);
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }
}
