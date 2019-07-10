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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author igeni
 */
@Entity
@Table(name = "bonosotorgados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonosotorgados.findAll", query = "SELECT b FROM Bonosotorgados b"),
    @NamedQuery(name = "Bonosotorgados.findById", query = "SELECT b FROM Bonosotorgados b WHERE b.id = :id"),
    @NamedQuery(name = "Bonosotorgados.findByAumentoEmp", query = "SELECT b FROM Bonosotorgados b WHERE b.aumentoEmp = :aumentoEmp"),
    @NamedQuery(name = "Bonosotorgados.findBySalarioEmp", query = "SELECT b FROM Bonosotorgados b WHERE b.salarioEmp = :salarioEmp"),
    @NamedQuery(name = "Bonosotorgados.findByEmpleadosId", query = "SELECT b FROM Bonosotorgados b WHERE b.empleadosId = :empleadosId"),
    @NamedQuery(name = "Bonosotorgados.findByBonosId", query = "SELECT b FROM Bonosotorgados b WHERE b.bonosId = :bonosId")})
public class Bonosotorgados implements Serializable {

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

    public Bonosotorgados() {
    }

    public Bonosotorgados(Integer id) {
        this.id = id;
    }

    public Bonosotorgados(Integer id, int empleadosId, int bonosId) {
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
        if (!(object instanceof Bonosotorgados)) {
            return false;
        }
        Bonosotorgados other = (Bonosotorgados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bonosotorgados[ id=" + id + " ]";
    }
    
}
