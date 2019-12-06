/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.PagosJpaController;
import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Empleados;
import entidades.Pagos;
import interfaces.AccionesBasicas;
import interfaces.Filtrar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PagosEmpleados implements AccionesBasicas {
    //Ingresar el pago a un empleado
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        PagosJpaController pagos = new PagosJpaController(em);
        pagos.create((Pagos)obj);
        return true;
    }
    //Filtrar pagos en un rango de fecha inicio y fecha final
    public void filtrado(DefaultTableModel modeloPagos, String fecha1, String fecha2, Empleados idempleado, EntityManager em) {
        try {
            PagosJpaController pagos = new PagosJpaController(em);
            while (modeloPagos.getRowCount() > 0)
                modeloPagos.removeRow(0);
            Object O[] = null;
            
            List<Pagos> listaPagos;
            if (fecha1.equals("") && fecha2.equals(""))
                listaPagos = pagos.filtrar(idempleado);
            else
            {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                listaPagos = pagos.filtrarFecha(formato.parse(fecha1), formato.parse(fecha2), idempleado);
            }
                
            for (int i = 0; i < listaPagos.size(); i++) {
                modeloPagos.addRow(O);
                modeloPagos.setValueAt(listaPagos.get(i).getId(), i, 0);
                modeloPagos.setValueAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(listaPagos.get(i).getFechaHora()), i, 1);
                modeloPagos.setValueAt(listaPagos.get(i).getMonto(), i, 2);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Obtener un pago
    public Pagos obtenerPago(Integer id, EntityManager em)
    {
        PagosJpaController pagos = new PagosJpaController(em);
        List<Pagos> listaPagos = pagos.obtenerPago(id);
        return listaPagos.get(0);
    }
    //Eliminar un pago
    public void eliminarPago(Integer id, EntityManager em)
    {
        try {
            PagosJpaController pagos = new PagosJpaController(em);
            pagos.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(PagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Editar un pago
    public void editarPago(Pagos pago, EntityManager em)
    {
        try {
            PagosJpaController pagos = new PagosJpaController(em);
            pagos.edit(pago);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
