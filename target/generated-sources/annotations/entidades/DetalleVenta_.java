package entidades;

import entidades.DetalleVentaPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T23:32:23", comments="EclipseLink-2.7.4.v20190115-rNA")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, String> descripcion;
    public static volatile SingularAttribute<DetalleVenta, DetalleVentaPK> detalleVentaPK;
    public static volatile SingularAttribute<DetalleVenta, Float> subTotal;
    public static volatile SingularAttribute<DetalleVenta, Integer> cantidad;

}