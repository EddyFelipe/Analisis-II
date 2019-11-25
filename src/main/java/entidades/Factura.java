/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.facturaPK.idfactura = :idfactura"),
    @NamedQuery(name = "Factura.findByFechaVenta", query = "SELECT f FROM Factura f WHERE f.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Factura.findByMontoVenta", query = "SELECT f FROM Factura f WHERE f.montoVenta = :montoVenta"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento"),
    @NamedQuery(name = "Factura.findByIdcliente", query = "SELECT f FROM Factura f WHERE f.facturaPK.idcliente = :idcliente")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturaPK;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_venta")
    private Double montoVenta;
    @Column(name = "descuento")
    private Float descuento;

    public Factura() {
    }

    public Factura(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Factura(int idfactura, int idcliente) {
        this.facturaPK = new FacturaPK(idfactura, idcliente);
    }

    public FacturaPK getFacturaPK() {
        return facturaPK;
    }

    public void setFacturaPK(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPK != null ? facturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaPK == null && other.facturaPK != null) || (this.facturaPK != null && !this.facturaPK.equals(other.facturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Factura[ facturaPK=" + facturaPK + " ]";
    }
    
}
