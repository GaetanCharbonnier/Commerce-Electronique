/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
	@NamedQuery(name = "Client.findByCode", query = "SELECT c FROM Client c WHERE c.code = :code"),
	@NamedQuery(name = "Client.findBySociete", query = "SELECT c FROM Client c WHERE c.societe = :societe"),
	@NamedQuery(name = "Client.findByContact", query = "SELECT c FROM Client c WHERE c.contact = :contact"),
	@NamedQuery(name = "Client.findByFonction", query = "SELECT c FROM Client c WHERE c.fonction = :fonction"),
	@NamedQuery(name = "Client.findByAdresse", query = "SELECT c FROM Client c WHERE c.adresse = :adresse"),
	@NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville"),
	@NamedQuery(name = "Client.findByRegion", query = "SELECT c FROM Client c WHERE c.region = :region"),
	@NamedQuery(name = "Client.findByCodePostal", query = "SELECT c FROM Client c WHERE c.codePostal = :codePostal"),
	@NamedQuery(name = "Client.findByPays", query = "SELECT c FROM Client c WHERE c.pays = :pays"),
	@NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
	@NamedQuery(name = "Client.findByFax", query = "SELECT c FROM Client c WHERE c.fax = :fax")})
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
        @Basic(optional = false)
        @Column(name = "CODE")
	private String code;
	
	@Basic(optional = false)
        @Column(name = "SOCIETE")
	private String societe;
	
	@Column(name = "CONTACT")
	private String contact;
	
	@Column(name = "FONCTION")
	private String fonction;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@Column(name = "VILLE")
	private String ville;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "CODE_POSTAL")
	private String codePostal;
	
	@Column(name = "PAYS")
	private String pays;
	
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "FAX")
	private String fax;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private Collection<Commande> commandeCollection;

	public Client() {
	}

	public Client(String code) {
		this.code = code;
	}

	public Client(String code, String societe) {
		this.code = code;
		this.societe = societe;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@XmlTransient
	public Collection<Commande> getCommandeCollection() {
		return commandeCollection;
	}

	public void setCommandeCollection(Collection<Commande> commandeCollection) {
		this.commandeCollection = commandeCollection;
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
		if (!(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.Client[ code=" + code + " ]";
	}
	
}
