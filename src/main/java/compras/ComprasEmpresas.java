/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

import controladores.CompraJpaController;
import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Compra;
import entidades.Compras;
import entidades.Empleados;
import interfaces.AccionesBasicas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import recursoshumanos.ClaseEmpleados;

/**
 *
 * @author User
 */
public class ComprasEmpresas implements AccionesBasicas{
    //Acá se registra una compra a una empresa
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        CompraJpaController compras = new CompraJpaController(em);
        compras.create((Compra)obj);
        return true;
    }
    //Acá se filtra (y añade a la tabla de compras) las compras realizadas por una empresa
    public void filtrado(DefaultTableModel modeloCompras, String fecha1, String fecha2, Compras idcompra, EntityManager em) {    
        try {
            ClaseEmpleados clasEmpleados = new ClaseEmpleados();
            CompraJpaController pagos = new CompraJpaController(em);
            while (modeloCompras.getRowCount() > 0)
                modeloCompras.removeRow(0);
            Object O[] = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            List<Compra> listaCompras = pagos.filtrarFecha(formato.parse(fecha1), formato.parse(fecha2), idcompra);
                
            for (int i = 0; i < listaCompras.size(); i++) {
                modeloCompras.addRow(O);
                modeloCompras.setValueAt(listaCompras.get(i).getId(), i, 0);
                modeloCompras.setValueAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(listaCompras.get(i).getFechaHora()), i, 1);
                modeloCompras.setValueAt(listaCompras.get(i).getTotal(), i, 2);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ComprasEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Acá se elimina una factura de compra
    public void eliminarCompra(Integer id, EntityManager em)
    {
        try {
            CompraJpaController compras = new CompraJpaController(em);
            compras.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ComprasEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComprasEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Acá se obtiene una factura de compra
    public Compra obtenerCompra(Integer id, EntityManager em)
    {
        CompraJpaController compras = new CompraJpaController(em);
        List<Compra> listaCompras = compras.obtenerCompra(id);
        return listaCompras.get(0);
    }
    //Acá se edita una factora de compra
    public void editarCompra(Compra compra, EntityManager em)
    {
        try {
            CompraJpaController compras = new CompraJpaController(em);
            compras.edit(compra);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComprasEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ComprasEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
