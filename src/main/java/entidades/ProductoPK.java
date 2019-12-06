/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class ProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private int idcategoria;

    public ProductoPK() {
    }

    public ProductoPK(int idproducto, int idcategoria) {
        this.idproducto = idproducto;
        this.idcategoria = idcategoria;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducto;
        hash += (int) idcategoria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPK)) {
            return false;
        }
        ProductoPK other = (ProductoPK) object;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idcategoria != other.idcategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductoPK[ idproducto=" + idproducto + ", idcategoria=" + idcategoria + " ]";
    }
    
}
