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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author igeni
 */
@Entity
@Table(name = "bonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonos.findAll", query = "SELECT b FROM Bonos b"),
    @NamedQuery(name = "Bonos.findById", query = "SELECT b FROM Bonos b WHERE b.id = :id"),
    @NamedQuery(name = "Bonos.findByBono", query = "SELECT b FROM Bonos b WHERE b.bono = :bono"),
    @NamedQuery(name = "Bonos.findByAumento", query = "SELECT b FROM Bonos b WHERE b.aumento = :aumento"),
    @NamedQuery(name = "Bonos.findByDescontinuado", query = "SELECT b FROM Bonos b WHERE b.descontinuado = :descontinuado")})
public class Bonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bono")
    private String bono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aumento")
    private Float aumento;
    @Column(name = "descontinuado")
    private Short descontinuado;

    public Bonos() {
    }

    public Bonos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBono() {
        return bono;
    }

    public void setBono(String bono) {
        this.bono = bono;
    }

    public Float getAumento() {
        return aumento;
    }

    public void setAumento(Float aumento) {
        this.aumento = aumento;
    }

    public Short getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Short descontinuado) {
        this.descontinuado = descontinuado;
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
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bonos[ id=" + id + " ]";
    }
    
}
