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
@Table(name = "infraccionesotorgadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infraccionesotorgadas.findAll", query = "SELECT i FROM Infraccionesotorgadas i"),
    @NamedQuery(name = "Infraccionesotorgadas.findById", query = "SELECT i FROM Infraccionesotorgadas i WHERE i.id = :id"),
    @NamedQuery(name = "Infraccionesotorgadas.findByPenalizacionEmp", query = "SELECT i FROM Infraccionesotorgadas i WHERE i.penalizacionEmp = :penalizacionEmp"),
    @NamedQuery(name = "Infraccionesotorgadas.findBySalarioEmp", query = "SELECT i FROM Infraccionesotorgadas i WHERE i.salarioEmp = :salarioEmp"),
    @NamedQuery(name = "Infraccionesotorgadas.findByEmpleadosId", query = "SELECT i FROM Infraccionesotorgadas i WHERE i.empleadosId = :empleadosId"),
    @NamedQuery(name = "Infraccionesotorgadas.findByInfraccionesId", query = "SELECT i FROM Infraccionesotorgadas i WHERE i.infraccionesId = :infraccionesId")})
public class Infraccionesotorgadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "penalizacionEmp")
    private Float penalizacionEmp;
    @Column(name = "salarioEmp")
    private Float salarioEmp;
    @Basic(optional = false)
    @Column(name = "empleados_id")
    private int empleadosId;
    @Basic(optional = false)
    @Column(name = "infracciones_id")
    private int infraccionesId;

    public Infraccionesotorgadas() {
    }

    public Infraccionesotorgadas(Integer id) {
        this.id = id;
    }

    public Infraccionesotorgadas(Integer id, int empleadosId, int infraccionesId) {
        this.id = id;
        this.empleadosId = empleadosId;
        this.infraccionesId = infraccionesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPenalizacionEmp() {
        return penalizacionEmp;
    }

    public void setPenalizacionEmp(Float penalizacionEmp) {
        this.penalizacionEmp = penalizacionEmp;
    }

    public Float getSalarioEmp() {
        return salarioEmp;
    }

    public void setSalarioEmp(Float salarioEmp) {
        this.salarioEmp = salarioEmp;
    }

    public int getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(int empleadosId) {
        this.empleadosId = empleadosId;
    }

    public int getInfraccionesId() {
        return infraccionesId;
    }

    public void setInfraccionesId(int infraccionesId) {
        this.infraccionesId = infraccionesId;
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
        if (!(object instanceof Infraccionesotorgadas)) {
            return false;
        }
        Infraccionesotorgadas other = (Infraccionesotorgadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Infraccionesotorgadas[ id=" + id + " ]";
    }
    
}
