
package singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author felipe
 */
public class singleton {
    
    private static EntityManagerFactory emf = null;
    
    public static EntityManager getConnection(){
        
        if( emf == null){
            try{
                emf = Persistence.createEntityManagerFactory("continental"); //Conexion a la base datos
            } catch(Exception e)
            {
                System.out.println("Excepción: " + e.toString());
            }
            
            
        }
       return emf.createEntityManager();
    }
    
}
