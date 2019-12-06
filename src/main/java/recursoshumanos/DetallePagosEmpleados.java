/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.DetallepagosJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Detallepagos;
import entidades.Pagos;
import interfaces.AccionesBasicas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DetallePagosEmpleados implements AccionesBasicas {
    //Registrar un detalle de pago a la factura de pago
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        DetallepagosJpaController detallepago = new DetallepagosJpaController(em);
        detallepago.create((Detallepagos)obj);
        return true;
    }
    //Obtener los detalles de pago de una factura de pago, este se añade al modelo de la tabla de detalles enviada desde el form de historial de pagos
    public void listarDetalles(DefaultTableModel modeloTabla, Pagos pago, EntityManager em)
    {
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        Object O[] = null;
        DetallepagosJpaController detalles = new DetallepagosJpaController(em);
        List<Detallepagos> lista = detalles.listadoDetalles(pago);
        for (int i = 0; i < lista.size(); i++) {
            modeloTabla.addRow(O);
            modeloTabla.setValueAt(lista.get(i).getId(), i, 0);
            modeloTabla.setValueAt(lista.get(i).getCantidad(), i, 1);
            modeloTabla.setValueAt(lista.get(i).getDescripcion(), i, 2);
            modeloTabla.setValueAt(lista.get(i).getMonto(), i, 3);
        }
    }
    //Eliminar un detalle de pago
    public void eliminarDetalle(Integer id, EntityManager em)
    {
        try {
            DetallepagosJpaController detalles = new DetallepagosJpaController(em);
            detalles.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DetallePagosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
