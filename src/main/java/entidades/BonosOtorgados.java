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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "bonosOtorgados")
@NamedQueries({
    @NamedQuery(name = "BonosOtorgados.findAll", query = "SELECT b FROM BonosOtorgados b"),
    @NamedQuery(name = "BonosOtorgados.findById", query = "SELECT b FROM BonosOtorgados b WHERE b.id = :id"),
    @NamedQuery(name = "BonosOtorgados.findByAumentoEmp", query = "SELECT b FROM BonosOtorgados b WHERE b.aumentoEmp = :aumentoEmp"),
    @NamedQuery(name = "BonosOtorgados.findBySalarioEmp", query = "SELECT b FROM BonosOtorgados b WHERE b.salarioEmp = :salarioEmp"),
    @NamedQuery(name = "BonosOtorgados.findByEmpleadosId", query = "SELECT b FROM BonosOtorgados b WHERE b.empleadosId = :empleadosId"),
    @NamedQuery(name = "BonosOtorgados.findByBonosId", query = "SELECT b FROM BonosOtorgados b WHERE b.bonosId = :bonosId")})
public class BonosOtorgados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aumentoEmp")
    private Float aumentoEmp;
    @Column(name = "salarioEmp")
    private Float salarioEmp;
    @Basic(optional = false)
    @Column(name = "empleados_id")
    private int empleadosId;
    @Basic(optional = false)
    @Column(name = "bonos_id")
    private int bonosId;

    public BonosOtorgados() {
    }

    public BonosOtorgados(Integer id) {
        this.id = id;
    }

    public BonosOtorgados(Integer id, int empleadosId, int bonosId) {
        this.id = id;
        this.empleadosId = empleadosId;
        this.bonosId = bonosId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAumentoEmp() {
        return aumentoEmp;
    }

    public void setAumentoEmp(Float aumentoEmp) {
        this.aumentoEmp = aumentoEmp;
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

    public int getBonosId() {
        return bonosId;
    }

    public void setBonosId(int bonosId) {
        this.bonosId = bonosId;
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
        if (!(object instanceof BonosOtorgados)) {
            return false;
        }
        BonosOtorgados other = (BonosOtorgados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.BonosOtorgados[ id=" + id + " ]";
    }
    
}
