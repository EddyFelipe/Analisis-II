/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import entidades.DetalleVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class List_Detalle implements DetalleFactura{
    
    private List<DetalleVenta> listaventa;
    private double  total;
    
    public List_Detalle(){
      listaventa = new ArrayList<>();
      total = 0;
    }
    @Override
    public void registart(Object detalle) {
        DetalleVenta dt = (DetalleVenta)detalle;
        total += dt.getSubTotal();
       listaventa.add(dt);
    }

    @Override
    public void modificar(Object detalle, int index) {
       DetalleVenta dt = listaventa.get(index);
       float precio = dt.getSubTotal()/dt.getCantidad();
       total -= dt.getSubTotal();
       dt.setCantidad(Integer.parseInt(detalle.toString()));
       dt.setSubTotal(dt.getCantidad()*precio);
       total += dt.getSubTotal();
       
       listaventa.set(index, dt);
    }

    @Override
    public boolean eliminar(int index) {
       try{
            listaventa.remove(index);
            return true;
       } catch (Exception ex){
         return false; 
       }
    }
    
    public List getLisDetalle(){ return listaventa; }
    public double getTotal(){ return total; }
    public float getSbutotal(int index){ return listaventa.get(index).getSubTotal(); }
    public DetalleVenta getDetalleVenta(int index){ return listaventa.get(index); }
  
}
