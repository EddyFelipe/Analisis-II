/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import entidades.Empleados;

/**
 *
 * @author User
 */
public interface Estado {
    public boolean ejecutarEstado(Empleados empleado);
}
