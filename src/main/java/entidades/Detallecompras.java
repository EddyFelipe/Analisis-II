/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "detallecompras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompras.findAll", query = "SELECT d FROM Detallecompras d"),
    @NamedQuery(name = "Detallecompras.findById", query = "SELECT d FROM Detallecompras d WHERE d.id = :id"),
    @NamedQuery(name = "Detallecompras.findByCantidad", query = "SELECT d FROM Detallecompras d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallecompras.findByDescripcion", query = "SELECT d FROM Detallecompras d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Detallecompras.listado", query = "SELECT d FROM Detallecompras d WHERE d.compraid = :idcompra"),
    @NamedQuery(name = "Detallecompras.eliminarDetalles", query = "DELETE FROM Detallecompras d WHERE d.compraid = :idcompra"),
    @NamedQuery(name = "Detallecompras.findByMonto", query = "SELECT d FROM Detallecompras d WHERE d.monto = :monto")})
public class Detallecompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Float monto;
    @JoinColumn(name = "Compra_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compra compraid;

    public Detallecompras() {
    }

    public Detallecompras(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Compra getCompraid() {
        return compraid;
    }

    public void setCompraid(Compra compraid) {
        this.compraid = compraid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompras)) {
            return false;
        }
        Detallecompras other = (Detallecompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallecompras[ id=" + id + " ]";
    }
    
}
