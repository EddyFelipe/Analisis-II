package entidades;

import entidades.FacturaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-10T18:15:12")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, FacturaPK> facturaPK;
    public static volatile SingularAttribute<Factura, Float> descuento;
    public static volatile SingularAttribute<Factura, Date> fechaVenta;
    public static volatile SingularAttribute<Factura, Double> montoVenta;

}