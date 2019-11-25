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
    @NamedQuery(name = "Detallepagos.findByDescripcion", query = "SELECT d FROM Detallepagos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Detallepagos.findByMonto", query = "SELECT d FROM Detallepagos d WHERE d.monto = :monto"),
    @NamedQuery(name = "Detallepagos.findByFecha", query = "SELECT d FROM Detallepagos d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Detallepagos.findByHora", query = "SELECT d FROM Detallepagos d WHERE d.hora = :hora")})
public class Detallepagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "monto")
    private String monto;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "hora")
    private String hora;
    @JoinColumn(name = "bonos_descuentos_id", referencedColumnName = "id")
    @ManyToOne
    private BonosDescuentos bonosDescuentosId;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados empleadosId;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public BonosDescuentos getBonosDescuentosId() {
        return bonosDescuentosId;
    }

    public void setBonosDescuentosId(BonosDescuentos bonosDescuentosId) {
        this.bonosDescuentosId = bonosDescuentosId;
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
