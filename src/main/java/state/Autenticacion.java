/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import entidades.Empleados;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursoshumanos.Contrasena;

/**
 *
 * @author User
 */
public class Autenticacion implements Estado{
    private String contrasena;
    
    @Override
    public boolean ejecutarEstado(Empleados empleado) {
        Contrasena contrasena = new Contrasena();
        try {
            if (contrasena.Desencriptar(empleado.getContrasena()).equals(this.contrasena)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Autenticacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }
    
}
