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
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t"),
    @NamedQuery(name = "Telefonos.findById", query = "SELECT t FROM Telefonos t WHERE t.id = :id"),
    @NamedQuery(name = "Telefonos.filtring", query = "SELECT t FROM Telefonos t WHERE t.numero LIKE :numempleado AND t.empleadosId = :empleadoId"),
    @NamedQuery(name = "Telefonos.filtrar", query = "SELECT t FROM Telefonos t WHERE t.numero LIKE :numempresa AND t.comprasIdcompras = :idCompras"),
    @NamedQuery(name = "Telefonos.encontrar", query = "SELECT t FROM Telefonos t WHERE t.empleadosId = :empleadoId"),
    @NamedQuery(name = "Telefonos.encontrarEmpresa", query = "SELECT t FROM Telefonos t WHERE t.comprasIdcompras = :idCompras"),
    @NamedQuery(name = "Telefonos.findByNumero", query = "SELECT t FROM Telefonos t WHERE t.numero = :numero")})
public class Telefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "compras_idcompras", referencedColumnName = "idcompras")
    @ManyToOne
    private Compras comprasIdcompras;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id")
    @ManyToOne
    private Empleados empleadosId;

    public Telefonos() {
    }

    public Telefonos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Compras getComprasIdcompras() {
        return comprasIdcompras;
    }

    public void setComprasIdcompras(Compras comprasIdcompras) {
        this.comprasIdcompras = comprasIdcompras;
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
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Telefonos[ id=" + id + " ]";
    }
    
}
