/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rbastide
 */
@Embeddable
public class LignePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
        @Column(name = "COMMANDE")
	private int commande;
	@Basic(optional = false)
        @Column(name = "PRODUIT")
	private int produit;

	public LignePK() {
	}

	public LignePK(int commande, int produit) {
		this.commande = commande;
		this.produit = produit;
	}

	public int getCommande() {
		return commande;
	}

	public void setCommande(int commande) {
		this.commande = commande;
	}

	public int getProduit() {
		return produit;
	}

	public void setProduit(int produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) commande;
		hash += (int) produit;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof LignePK)) {
			return false;
		}
		LignePK other = (LignePK) object;
		if (this.commande != other.commande) {
			return false;
		}
		if (this.produit != other.produit) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.LignePK[ commande=" + commande + ", produit=" + produit + " ]";
	}
	
}
