/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import interfaces.*;
import entidades.*;
import controladores.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListModel;

/**
 *
 * @author felipe
 */
public class Ventas  implements AccionesBasicas{

       List<Producto> listtemporal;
     
       
       public Ventas(){
         listtemporal = new ArrayList<>();
       }
    

    
    public DefaultListModel filtradoPoducto(String filter, EntityManager em){
        FiltrarProductoNombre fpn = new FiltrarProductoNombre();
        listtemporal = fpn.buscarObjects(filter, em);
        
         DefaultListModel modelolist = new DefaultListModel();
         
         for (Producto producto : listtemporal){
           modelolist.addElement(producto.getNombre());
         }
         return modelolist;
    }
    
    public Producto obtenerProducto(int index){ return listtemporal.get(index); }

    @Override
    public boolean registrarObject(Object obj, EntityManager em) {
        List<Object> objects = (List<Object>) obj;
        Cliente cliente = (Cliente)objects.get(0);
        List_Detalle detalles = (List_Detalle)objects.get(1);
        
        if( detalles.getLisDetalle().size()  > 0){
            try {
                //Insercion de un cliente
                ClienteJpaController controllercliente = new ClienteJpaController(em);
                controllercliente.create(cliente);
                //ClienteJpaController cle = new ClienteJpaController(singleton.singleton.getConnection());
                int idcliente = controllercliente.findMaxid();
            
                //Creacion de una factura
                FacturaJpaController controllerfactura = new  FacturaJpaController(em);
                Factura factura = new Factura(0, idcliente);
                factura.setDescuento((float)0);
                factura.setMontoVenta(detalles.getTotal());
                controllerfactura.create(factura);
                
                int idfactura = controllerfactura.findMaxid();
                
                List<DetalleVenta> listdetalle = detalles.getLisDetalle();
                DescontarExistencia descontarexistencia = new DescontarExistencia();
                
                DetalleVentaJpaController controllerdetalle = new DetalleVentaJpaController(em);
                
                // Creacion de un detalle de ventas y descuento de exisntencia 
                for(DetalleVenta detventa : listdetalle ){
                    
                    if(descontarexistencia.registrarObject(detventa, em)){
                         detventa.getDetalleVentaPK().setIdfactura(idfactura);
                         controllerdetalle.create(detventa);       
                    }
                    else
                        return false;
                }
                
                
                return true;
            } catch (Exception ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
}
