/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

import controladores.CompraJpaController;
import controladores.ComprasJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Compras;
import interfaces.AccionesBasicas;
import interfaces.Filtrar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Empresas implements AccionesBasicas {
    //Acá se registra a una empresa
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        ComprasJpaController empresa = new ComprasJpaController(em);
        empresa.create((Compras)obj);
        return true;
    }
    //Acá se busca a una empresa por medio de un filtro de MySQL (y se añade el listado encontrado al modelo de la tabla de empresas)
    public void buscar(EntityManager em, DefaultTableModel modeloTabla, String contenido, boolean mostrartodo) {
        while (modeloTabla.getRowCount() > 0)
            modeloTabla.removeRow(0);
        Object O[] = null;
        ComprasJpaController buscar = new ComprasJpaController(em);
        List<Compras> empresas = null;
        if (contenido.equals(""))
            empresas = buscar.findComprasEntities();
        else
        {
            empresas = buscar.filtrar(contenido);
        }
        if (mostrartodo == true)
        {
            for (int i = 0; i < empresas.size(); i++) {
                modeloTabla.addRow(O);
                modeloTabla.setValueAt(empresas.get(i).getIdcompras(), i, 0);
                modeloTabla.setValueAt(empresas.get(i).getEmpresa(), i, 1);
                modeloTabla.setValueAt(empresas.get(i).getDescripcion(), i, 2);
            }
        }
        else
        {
            int fila = 0;
            for (int i = 0; i < empresas.size(); i++) {
                if (empresas.get(i).getActivo() == 1)
                {
                    modeloTabla.addRow(O);
                    modeloTabla.setValueAt(empresas.get(i).getIdcompras(), fila, 0);
                    modeloTabla.setValueAt(empresas.get(i).getEmpresa(), fila, 1);
                    modeloTabla.setValueAt(empresas.get(i).getDescripcion(), fila, 2);
                    fila++;
                }
            }
        }
    }
    //Acá se obtienen los datos de una empresa
    public Compras obtenerEmpresa(EntityManager em, Integer idEmpresa)
    {
        ComprasJpaController controlador = new ComprasJpaController(em);
        return controlador.findCompras(idEmpresa);
    }
    //Acá se modifican los datos de una empresa
    public void modificarEmpresa(EntityManager em, DefaultTableModel modeloTabla, Compras empresa)
    {
        try {
            ComprasJpaController controlador = new ComprasJpaController(em);
            controlador.edit(empresa);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
