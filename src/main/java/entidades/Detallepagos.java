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
@Table(name = "detallepagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepagos.findAll", query = "SELECT d FROM Detallepagos d"),
    @NamedQuery(name = "Detallepagos.findById", query = "SELECT d FROM Detallepagos d WHERE d.id = :id"),
    @NamedQuery(name = "Detallepagos.findByCantidad", query = "SELECT d FROM Detallepagos d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallepagos.findByDescripcion", query = "SELECT d FROM Detallepagos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Detallepagos.listado", query = "SELECT d FROM Detallepagos d WHERE d.pagosId = :pagosId"),
    @NamedQuery(name = "Detallepagos.findByMonto", query = "SELECT d FROM Detallepagos d WHERE d.monto = :monto")})
public class Detallepagos implements Serializable {

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
    @JoinColumn(name = "bonos_descuentos_id", referencedColumnName = "id")
    @ManyToOne
    private BonosDescuentos bonosDescuentosId;
    @JoinColumn(name = "pagos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pagos pagosId;

    public Detallepagos() {
    }

    public Detallepagos(Integer id) {
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

    public BonosDescuentos getBonosDescuentosId() {
        return bonosDescuentosId;
    }

    public void setBonosDescuentosId(BonosDescuentos bonosDescuentosId) {
        this.bonosDescuentosId = bonosDescuentosId;
    }

    public Pagos getPagosId() {
        return pagosId;
    }

    public void setPagosId(Pagos pagosId) {
        this.pagosId = pagosId;
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
        if (!(object instanceof Detallepagos)) {
            return false;
        }
        Detallepagos other = (Detallepagos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallepagos[ id=" + id + " ]";
    }
    
}
