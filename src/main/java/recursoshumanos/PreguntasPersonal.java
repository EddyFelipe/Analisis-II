/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanos;

/**
 *
 * @author User
 */
import interfaces.RecursosHumanosS;
import java.util.ArrayList;
import java.util.Vector;

public class PreguntasPersonal implements RecursosHumanosS {

  private ArrayList preguntasEmpleados;

  private static PreguntasPersonal preguntasPersona;

    private Vector  preguntasPersonal;
    
  public static PreguntasPersonal iniciarEstancia() {
  return null;
  }

    @Override
    public void agregar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(String dato, String datoant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recolectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}