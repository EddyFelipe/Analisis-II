package entidades;

import entidades.ProductoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-09T10:37:16")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Integer> reservado;
    public static volatile SingularAttribute<Producto, Short> eliminado;
    public static volatile SingularAttribute<Producto, ProductoPK> productoPK;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Float> precioVenta;
    public static volatile SingularAttribute<Producto, String> nombre;

}