package entidades;

import entidades.ProductoPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T23:32:23", comments="EclipseLink-2.7.4.v20190115-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Integer> reservado;
    public static volatile SingularAttribute<Producto, Short> eliminado;
    public static volatile SingularAttribute<Producto, ProductoPK> productoPK;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Float> precioVenta;
    public static volatile SingularAttribute<Producto, String> nombre;

}