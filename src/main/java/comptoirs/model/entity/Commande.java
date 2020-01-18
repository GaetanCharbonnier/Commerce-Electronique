package comptoirs.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
	@NamedQuery(name = "Commande.findByNumero", query = "SELECT c FROM Commande c WHERE c.numero = :numero"),
	@NamedQuery(name = "Commande.findBySaisieLe", query = "SELECT c FROM Commande c WHERE c.saisieLe = :saisieLe"),
	@NamedQuery(name = "Commande.findByEnvoyeeLe", query = "SELECT c FROM Commande c WHERE c.envoyeeLe = :envoyeeLe"),
	@NamedQuery(name = "Commande.findByPort", query = "SELECT c FROM Commande c WHERE c.port = :port"),
	@NamedQuery(name = "Commande.findByDestinataire", query = "SELECT c FROM Commande c WHERE c.destinataire = :destinataire"),
	@NamedQuery(name = "Commande.findByAdresseLivraison", query = "SELECT c FROM Commande c WHERE c.adresseLivraison = :adresseLivraison"),
	@NamedQuery(name = "Commande.findByVilleLivraison", query = "SELECT c FROM Commande c WHERE c.villeLivraison = :villeLivraison"),
	@NamedQuery(name = "Commande.findByRegionLivraison", query = "SELECT c FROM Commande c WHERE c.regionLivraison = :regionLivraison"),
	@NamedQuery(name = "Commande.findByCodePostalLivrais", query = "SELECT c FROM Commande c WHERE c.codePostalLivrais = :codePostalLivrais"),
	@NamedQuery(name = "Commande.findByPaysLivraison", query = "SELECT c FROM Commande c WHERE c.paysLivraison = :paysLivraison"),
	@NamedQuery(name = "Commande.findByRemise", query = "SELECT c FROM Commande c WHERE c.remise = :remise")})
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "NUMERO")
	private Integer numero;

	@Basic(optional = false)
        @Column(name = "SAISIE_LE")
        @Temporal(TemporalType.DATE)
	private Date saisieLe;

	@Column(name = "ENVOYEE_LE")
        @Temporal(TemporalType.DATE)
	private Date envoyeeLe;

	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PORT")
	private BigDecimal port;

	@Column(name = "DESTINATAIRE")
	private String destinataire;

	@Column(name = "ADRESSE_LIVRAISON")
	private String adresseLivraison;

	@Column(name = "VILLE_LIVRAISON")
	private String villeLivraison;

	@Column(name = "REGION_LIVRAISON")
	private String regionLivraison;

	@Column(name = "CODE_POSTAL_LIVRAIS")
	private String codePostalLivrais;

	@Column(name = "PAYS_LIVRAISON")
	private String paysLivraison;

	@Basic(optional = false)
        @Column(name = "REMISE")
	private BigDecimal remise;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande1")
	private Collection<Ligne> ligneCollection;

	@JoinColumn(name = "CLIENT", referencedColumnName = "CODE")
        @ManyToOne(optional = false)
	private Client client;

	public Commande() {
	}

	public Commande(Integer numero) {
		this.numero = numero;
	}

	public Commande(Integer numero, Date saisieLe, BigDecimal remise) {
		this.numero = numero;
		this.saisieLe = saisieLe;
		this.remise = remise;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getSaisieLe() {
		return saisieLe;
	}

	public void setSaisieLe(Date saisieLe) {
		this.saisieLe = saisieLe;
	}

	public Date getEnvoyeeLe() {
		return envoyeeLe;
	}

	public void setEnvoyeeLe(Date envoyeeLe) {
		this.envoyeeLe = envoyeeLe;
	}

	public BigDecimal getPort() {
		return port;
	}

	public void setPort(BigDecimal port) {
		this.port = port;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getVilleLivraison() {
		return villeLivraison;
	}

	public void setVilleLivraison(String villeLivraison) {
		this.villeLivraison = villeLivraison;
	}

	public String getRegionLivraison() {
		return regionLivraison;
	}

	public void setRegionLivraison(String regionLivraison) {
		this.regionLivraison = regionLivraison;
	}

	public String getCodePostalLivrais() {
		return codePostalLivrais;
	}

	public void setCodePostalLivrais(String codePostalLivrais) {
		this.codePostalLivrais = codePostalLivrais;
	}

	public String getPaysLivraison() {
		return paysLivraison;
	}

	public void setPaysLivraison(String paysLivraison) {
		this.paysLivraison = paysLivraison;
	}

	public BigDecimal getRemise() {
		return remise;
	}

	public void setRemise(BigDecimal remise) {
		this.remise = remise;
	}

	@XmlTransient
	public Collection<Ligne> getLigneCollection() {
		return ligneCollection;
	}

	public void setLigneCollection(Collection<Ligne> ligneCollection) {
		this.ligneCollection = ligneCollection;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (numero != null ? numero.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Commande)) {
			return false;
		}
		Commande other = (Commande) object;
		if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.Commande[ numero=" + numero + " ]";
	}
	
}
