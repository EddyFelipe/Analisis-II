/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import interfaces.AccionesBasicas;
import javax.persistence.EntityManager;
import entidades.Producto;
import entidades.DetalleVenta;
import controladores.ProductoJpaController;
import entidades.ProductoPK;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author felipe
 */
public class DescontarExistencia implements AccionesBasicas{

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        try {
            ProductoJpaController controllerproducto = new ProductoJpaController(em);
            DetalleVenta detalleventa = (DetalleVenta)obj;
            
            Producto producto = controllerproducto.findProducto(new ProductoPK(detalleventa.getDetalleVentaPK().getIdproducto(), detalleventa.getDetalleVentaPK().getIdfactura()));
            producto.setCantidad(producto.getCantidad() - detalleventa.getCantidad());
            controllerproducto.edit(producto);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DescontarExistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
