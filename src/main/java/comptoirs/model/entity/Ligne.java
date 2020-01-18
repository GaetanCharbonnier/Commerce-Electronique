package comptoirs.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "LIGNE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Ligne.findAll", query = "SELECT l FROM Ligne l"),
	@NamedQuery(name = "Ligne.findByCommande", query = "SELECT l FROM Ligne l WHERE l.lignePK.commande = :commande"),
	@NamedQuery(name = "Ligne.findByProduit", query = "SELECT l FROM Ligne l WHERE l.lignePK.produit = :produit"),
	@NamedQuery(name = "Ligne.findByQuantite", query = "SELECT l FROM Ligne l WHERE l.quantite = :quantite")})
public class Ligne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected LignePK lignePK;
	@Basic(optional = false)

	@Column(name = "QUANTITE")
	private short quantite;

	@JoinColumn(name = "COMMANDE", referencedColumnName = "NUMERO", insertable = false, updatable = false)
        @ManyToOne(optional = false)
	private Commande commande1;

	@JoinColumn(name = "PRODUIT", referencedColumnName = "REFERENCE", insertable = false, updatable = false)
        @ManyToOne(optional = false)
	private Produit produit1;

	public Ligne() {
	}

	public Ligne(LignePK lignePK) {
		this.lignePK = lignePK;
	}

	public Ligne(LignePK lignePK, short quantite) {
		this.lignePK = lignePK;
		this.quantite = quantite;
	}

	public Ligne(int commande, int produit) {
		this.lignePK = new LignePK(commande, produit);
	}

	public LignePK getLignePK() {
		return lignePK;
	}

	public void setLignePK(LignePK lignePK) {
		this.lignePK = lignePK;
	}

	public short getQuantite() {
		return quantite;
	}

	public void setQuantite(short quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande1() {
		return commande1;
	}

	public void setCommande1(Commande commande1) {
		this.commande1 = commande1;
	}

	public Produit getProduit1() {
		return produit1;
	}

	public void setProduit1(Produit produit1) {
		this.produit1 = produit1;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lignePK != null ? lignePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Ligne)) {
			return false;
		}
		Ligne other = (Ligne) object;
		if ((this.lignePK == null && other.lignePK != null) || (this.lignePK != null && !this.lignePK.equals(other.lignePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.Ligne[ lignePK=" + lignePK + " ]";
	}
	
}
