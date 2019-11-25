/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByDescripcion", query = "SELECT d FROM DetalleVenta d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleVenta.findBySubTotal", query = "SELECT d FROM DetalleVenta d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVenta.findByIdproducto", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.idproducto = :idproducto"),
    @NamedQuery(name = "DetalleVenta.findByIdfactura", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.idfactura = :idfactura")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaPK detalleVentaPK;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_total")
    private Float subTotal;
    @Column(name = "cantidad")
    private Integer cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public DetalleVenta(int idproducto, int idfactura) {
        this.detalleVentaPK = new DetalleVentaPK(idproducto, idfactura);
    }

    public DetalleVentaPK getDetalleVentaPK() {
        return detalleVentaPK;
    }

    public void setDetalleVentaPK(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleVentaPK != null ? detalleVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.detalleVentaPK == null && other.detalleVentaPK != null) || (this.detalleVentaPK != null && !this.detalleVentaPK.equals(other.detalleVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleVenta[ detalleVentaPK=" + detalleVentaPK + " ]";
    }
    
}
