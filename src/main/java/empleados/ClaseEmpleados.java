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

/**
 *
 * @author igeni
 */
public class ClaseEmpleados implements Filtrar{

    @Override
    public List buscarObjects(Object obj) {
        EntityManager em = singleton.getConnection();
        EmpleadosJpaController ContEmpleados = new EmpleadosJpaController(em);
        List<Empleados> lista = null;
        if (String.valueOf(obj).equals(""))
        {
            Object O[] = null;
            lista = ContEmpleados.findEmpleadosEntities();
            //TypedQuery<Empleados> query = em.createNameQuery("Empleado.filtrar", Empleados.class);
            //return query.getResultList();
        }
        else
        {
            Query filtEmpleados = em.createNativeQuery("SELECT id_empleados, nombre, apellido, estado, direccion, usuario FROM empleados WHERE nombre like '?%'");
            lista = filtEmpleados.getResultList();
        }
        return lista;
    }
    
}
