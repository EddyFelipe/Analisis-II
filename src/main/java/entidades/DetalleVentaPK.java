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
public class DetalleVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @Basic(optional = false)
    @Column(name = "idfactura")
    private int idfactura;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(int idproducto, int idfactura) {
        this.idproducto = idproducto;
        this.idfactura = idfactura;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducto;
        hash += (int) idfactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaPK)) {
            return false;
        }
        DetalleVentaPK other = (DetalleVentaPK) object;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idfactura != other.idfactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleVentaPK[ idproducto=" + idproducto + ", idfactura=" + idfactura + " ]";
    }
    
}
