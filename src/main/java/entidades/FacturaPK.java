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
public class FacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idfactura")
    private int idfactura;
    @Basic(optional = false)
    @Column(name = "idcliente")
    private int idcliente;

    public FacturaPK() {
    }

    public FacturaPK(int idfactura, int idcliente) {
        this.idfactura = idfactura;
        this.idcliente = idcliente;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfactura;
        hash += (int) idcliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPK)) {
            return false;
        }
        FacturaPK other = (FacturaPK) object;
        if (this.idfactura != other.idfactura) {
            return false;
        }
        if (this.idcliente != other.idcliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FacturaPK[ idfactura=" + idfactura + ", idcliente=" + idcliente + " ]";
    }
    
}
