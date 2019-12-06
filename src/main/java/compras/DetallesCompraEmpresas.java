/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

import controladores.DetallecomprasJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Compra;
import entidades.Detallecompras;
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
public class DetallesCompraEmpresas implements AccionesBasicas{
    //Acá se registra un detalle de compra de una factura de compra
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        DetallecomprasJpaController detallecompra = new DetallecomprasJpaController(em);
        detallecompra.create((Detallecompras)obj);
        return true;
    }
    //Acá se añaden los detalles de la compra al modelo de la tabla de detalles
    public void listarDetalles(DefaultTableModel modeloTabla, Compra compra, EntityManager em)
    {
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        Object O[] = null;
        DetallecomprasJpaController detalles = new DetallecomprasJpaController(em);
        List<Detallecompras> lista = detalles.listadoDetalles(compra);
        for (int i = 0; i < lista.size(); i++) {
            modeloTabla.addRow(O);
            modeloTabla.setValueAt(lista.get(i).getId(), i, 0);
            modeloTabla.setValueAt(lista.get(i).getCantidad(), i, 1);
            modeloTabla.setValueAt(lista.get(i).getDescripcion(), i, 2);
            modeloTabla.setValueAt(lista.get(i).getMonto(), i, 3);
        }
    }
    //Acá se edita el detalle de compra de una compra
    public void editarObject(Object obj, EntityManager em){
        try {
            DetallecomprasJpaController detallecompra = new DetallecomprasJpaController(em);
            detallecompra.edit((Detallecompras)obj);
        } catch (Exception ex) {
            Logger.getLogger(DetallesCompraEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Acá se elimina el detalle de compra de una compra
    public void eliminarDetalles(Integer id, EntityManager em)
    {
        try {
            DetallecomprasJpaController detallecompra = new DetallecomprasJpaController(em);
            detallecompra.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DetallesCompraEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Acá se obtiene un detalle de compra
    public Detallecompras obtenerDetalleCompra(Integer id, EntityManager em)
    {
        DetallecomprasJpaController detallecompra = new DetallecomprasJpaController(em);
        List<Detallecompras> listaDetalles = detallecompra.obtenerCompra(id);
        return listaDetalles.get(0);
    }
}