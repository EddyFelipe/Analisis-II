
package singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author felipe
 */
public class singleton {
    
    private static EntityManager em = null;
    
    public static EntityManager getConnection(){
        
        if( em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("continental"); //Conexion a la base datos
            em = emf.createEntityManager();
        }
       return em;
    }
    
}
