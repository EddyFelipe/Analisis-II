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
@Table(name = "infraccionesOtorgadas")
@NamedQueries({
    @NamedQuery(name = "InfraccionesOtorgadas.findAll", query = "SELECT i FROM InfraccionesOtorgadas i"),
    @NamedQuery(name = "InfraccionesOtorgadas.findById", query = "SELECT i FROM InfraccionesOtorgadas i WHERE i.id = :id"),
    @NamedQuery(name = "InfraccionesOtorgadas.findByPenalizacionEmp", query = "SELECT i FROM InfraccionesOtorgadas i WHERE i.penalizacionEmp = :penalizacionEmp"),
    @NamedQuery(name = "InfraccionesOtorgadas.findBySalarioEmp", query = "SELECT i FROM InfraccionesOtorgadas i WHERE i.salarioEmp = :salarioEmp"),
    @NamedQuery(name = "InfraccionesOtorgadas.findByEmpleadosId", query = "SELECT i FROM InfraccionesOtorgadas i WHERE i.empleadosId = :empleadosId"),
    @NamedQuery(name = "InfraccionesOtorgadas.findByInfraccionesId", query = "SELECT i FROM InfraccionesOtorgadas i WHERE i.infraccionesId = :infraccionesId")})
public class InfraccionesOtorgadas implements Serializable {

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

    public InfraccionesOtorgadas() {
    }

    public InfraccionesOtorgadas(Integer id) {
        this.id = id;
    }

    public InfraccionesOtorgadas(Integer id, int empleadosId, int infraccionesId) {
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
        if (!(object instanceof InfraccionesOtorgadas)) {
            return false;
        }
        InfraccionesOtorgadas other = (InfraccionesOtorgadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InfraccionesOtorgadas[ id=" + id + " ]";
    }
    
}
