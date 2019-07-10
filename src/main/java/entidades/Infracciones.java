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

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "infracciones")
@NamedQueries({
    @NamedQuery(name = "Infracciones.findAll", query = "SELECT i FROM Infracciones i"),
    @NamedQuery(name = "Infracciones.findById", query = "SELECT i FROM Infracciones i WHERE i.id = :id"),
    @NamedQuery(name = "Infracciones.findByInfraccion", query = "SELECT i FROM Infracciones i WHERE i.infraccion = :infraccion"),
    @NamedQuery(name = "Infracciones.findByPenalizacion", query = "SELECT i FROM Infracciones i WHERE i.penalizacion = :penalizacion"),
    @NamedQuery(name = "Infracciones.findByDescontinuado", query = "SELECT i FROM Infracciones i WHERE i.descontinuado = :descontinuado")})
public class Infracciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "infraccion")
    private String infraccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "penalizacion")
    private Float penalizacion;
    @Column(name = "descontinuado")
    private Short descontinuado;

    public Infracciones() {
    }

    public Infracciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public Float getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(Float penalizacion) {
        this.penalizacion = penalizacion;
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
        if (!(object instanceof Infracciones)) {
            return false;
        }
        Infracciones other = (Infracciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Infracciones[ id=" + id + " ]";
    }
    
}
