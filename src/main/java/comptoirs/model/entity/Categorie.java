package comptoirs.model.entity;

import java.io.Serializable;
import java.util.Collection;

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
@Entity
@Table(name = "CATEGORIE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
	@NamedQuery(name = "Categorie.findByCode", query = "SELECT c FROM Categorie c WHERE c.code = :code"),
	@NamedQuery(name = "Categorie.findByLibelle", query = "SELECT c FROM Categorie c WHERE c.libelle = :libelle"),
	@NamedQuery(name = "Categorie.findByDescription", query = "SELECT c FROM Categorie c WHERE c.description = :description")
})
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "CODE")
	private Integer code;
	@Basic(optional = false)
        @Column(name = "LIBELLE")
	private String libelle;
	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	@XmlTransient
	private Collection<Produit> produitCollection;

	public Categorie() {
	}

	public Categorie(Integer code) {
		this.code = code;
	}

	public Categorie(Integer code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public Collection<Produit> getProduitCollection() {
		return produitCollection;
	}

	public void setProduitCollection(Collection<Produit> produitCollection) {
		this.produitCollection = produitCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (code != null ? code.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Categorie)) {
			return false;
		}
		Categorie other = (Categorie) object;
		if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.Categorie[ code=" + code + " ]";
	}
	
}
