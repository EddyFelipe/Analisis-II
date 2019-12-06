/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByIdcompras", query = "SELECT c FROM Compras c WHERE c.idcompras = :idcompras"),
    @NamedQuery(name = "Compras.findByEmpresa", query = "SELECT c FROM Compras c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Compras.findByDescripcion", query = "SELECT c FROM Compras c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Compras.filtrar", query = "SELECT c FROM Compras c WHERE c.empresa LIKE :empresa"),
    @NamedQuery(name = "Compras.findByActivo", query = "SELECT c FROM Compras c WHERE c.activo = :activo")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompras")
    private Integer idcompras;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private Short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprasIdcompras")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "comprasIdcompras")
    private List<Telefonos> telefonosList;

    public Compras() {
    }

    public Compras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public Integer getIdcompras() {
        return idcompras;
    }

    public void setIdcompras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Telefonos> getTelefonosList() {
        return telefonosList;
    }

    public void setTelefonosList(List<Telefonos> telefonosList) {
        this.telefonosList = telefonosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompras != null ? idcompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idcompras == null && other.idcompras != null) || (this.idcompras != null && !this.idcompras.equals(other.idcompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Compras[ idcompras=" + idcompras + " ]";
    }
    
}
