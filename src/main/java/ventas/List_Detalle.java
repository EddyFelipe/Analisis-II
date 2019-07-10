/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class List_Detalle implements DetalleFactura{
    
   
    
    public List_Detalle(){

    }
    

    @Override
    public void registart(DetalleFactura detalle) {
       //listaventa.add(detalle);
    }

    @Override
    public void modificar(DetalleFactura detall, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
