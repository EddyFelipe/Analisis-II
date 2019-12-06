/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findById", query = "SELECT p FROM Pagos p WHERE p.id = :id"),
    @NamedQuery(name = "Pagos.findByFechaHora", query = "SELECT p FROM Pagos p WHERE p.fechaHora = :fechaHora"),
    @NamedQuery(name = "Pagos.filtrado", query = "SELECT p FROM Pagos p WHERE p.fechaHora BETWEEN :fecha1 AND :fecha2 AND p.empleadosId = :idempleado"),
    @NamedQuery(name = "Pagos.filtradoFecha", query = "SELECT p FROM Pagos p WHERE p.empleadosId = :idempleado"),
    @NamedQuery(name = "Pagos.findByMonto", query = "SELECT p FROM Pagos p WHERE p.monto = :monto")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Float monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagosId")
    private List<Detallepagos> detallepagosList;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados empleadosId;

    public Pagos() {
    }

    public Pagos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    @XmlTransient
    public List<Detallepagos> getDetallepagosList() {
        return detallepagosList;
    }

    public void setDetallepagosList(List<Detallepagos> detallepagosList) {
        this.detallepagosList = detallepagosList;
    }

    public Empleados getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Empleados empleadosId) {
        this.empleadosId = empleadosId;
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
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pagos[ id=" + id + " ]";
    }
    
}
