/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "bonos_descuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonosDescuentos.findAll", query = "SELECT b FROM BonosDescuentos b"),
    @NamedQuery(name = "BonosDescuentos.findById", query = "SELECT b FROM BonosDescuentos b WHERE b.id = :id"),
    @NamedQuery(name = "BonosDescuentos.findByDescripci\u00f3n", query = "SELECT b FROM BonosDescuentos b WHERE b.descripci\u00f3n = :descripci\u00f3n"),
    @NamedQuery(name = "BonosDescuentos.findByMonto", query = "SELECT b FROM BonosDescuentos b WHERE b.monto = :monto"),
    @NamedQuery(name = "BonosDescuentos.findByDescontinuado", query = "SELECT b FROM BonosDescuentos b WHERE b.descontinuado = :descontinuado"),
    @NamedQuery(name = "BonosDescuentos.findByEsBono", query = "SELECT b FROM BonosDescuentos b WHERE b.esBono = :esBono"),
    @NamedQuery(name = "BonosDescuentos.filtring", query = "SELECT b FROM BonosDescuentos b WHERE b.descripci\u00f3n LIKE :descripcion"),
    @NamedQuery(name = "BonosDescuentos.findByEsPorcentaje", query = "SELECT b FROM BonosDescuentos b WHERE b.esPorcentaje = :esPorcentaje")})
public class BonosDescuentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripci\u00f3n")
    private String descripción;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Float monto;
    @Column(name = "descontinuado")
    private Short descontinuado;
    @Column(name = "esBono")
    private Short esBono;
    @Column(name = "esPorcentaje")
    private Short esPorcentaje;
    @OneToMany(mappedBy = "bonosDescuentosId")
    private List<Detallepagos> detallepagosList;

    public BonosDescuentos() {
    }

    public BonosDescuentos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Short getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Short descontinuado) {
        this.descontinuado = descontinuado;
    }

    public Short getEsBono() {
        return esBono;
    }

    public void setEsBono(Short esBono) {
        this.esBono = esBono;
    }

    public Short getEsPorcentaje() {
        return esPorcentaje;
    }

    public void setEsPorcentaje(Short esPorcentaje) {
        this.esPorcentaje = esPorcentaje;
    }

    @XmlTransient
    public List<Detallepagos> getDetallepagosList() {
        return detallepagosList;
    }

    public void setDetallepagosList(List<Detallepagos> detallepagosList) {
        this.detallepagosList = detallepagosList;
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
        if (!(object instanceof BonosDescuentos)) {
            return false;
        }
        BonosDescuentos other = (BonosDescuentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.BonosDescuentos[ id=" + id + " ]";
    }
    
}
