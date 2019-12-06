/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

import controladores.BonosDescuentosJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.BonosDescuentos;
import interfaces.AccionesBasicas;
import interfaces.Filtrar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author User
 */
public class Bonos_Descuentos implements AccionesBasicas, Filtrar {
    //Ingresar un bono/descuento
    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        BonosDescuentosJpaController bdjc = new BonosDescuentosJpaController(em);
        bdjc.create((BonosDescuentos)obj);
        return true;
    }
    //Editar un bono/descuento
    public void editarObject(Object obj, EntityManager em)
    {
        try {
            BonosDescuentosJpaController bdjc = new BonosDescuentosJpaController(em);
            bdjc.edit((BonosDescuentos)obj);
        } catch (Exception ex) {
            Logger.getLogger(Bonos_Descuentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Eliminar un bono/descuento
    public void eliminarObject(Object obj, EntityManager em)
    {
        try {
            BonosDescuentosJpaController bdjc = new BonosDescuentosJpaController(em);
            bdjc.destroy(Integer.parseInt((String) obj));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Bonos_Descuentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Validar si un bono/descuento ya existe
    public BonosDescuentos buscarBono_Descuento(EntityManager em, String dato) {
        BonosDescuentosJpaController controlador = new BonosDescuentosJpaController(em);
        List<BonosDescuentos> lista = null;
        lista = controlador.encontrarBono_Descuento(dato);
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }
    //Buscar un bono/descuento por filtro o sin este
    @Override
    public List buscarObjects(Object obj, EntityManager em) {
        BonosDescuentosJpaController bdjc = new BonosDescuentosJpaController(em);
        if (String.valueOf(obj).equals(""))
            return bdjc.findBonosDescuentosEntities();
        else
            return bdjc.filtrar(String.valueOf(obj));
    }
    
}
