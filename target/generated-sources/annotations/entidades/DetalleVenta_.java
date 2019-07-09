package entidades;

import entidades.DetalleVentaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-09T10:37:16")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, String> descripcion;
    public static volatile SingularAttribute<DetalleVenta, DetalleVentaPK> detalleVentaPK;
    public static volatile SingularAttribute<DetalleVenta, Float> subTotal;
    public static volatile SingularAttribute<DetalleVenta, Integer> cantidad;

}