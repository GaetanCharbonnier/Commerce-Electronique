package comptoirs.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * un "Data Transfer Object" (DTO) pour les statistiques
 * "Unités vendues par catégorie"
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsResult {

	public StatsResult(String libelle, Long unites) {
		this.unites = unites;
		this.libelle = libelle;
	}
	
	public StatsResult() {
		this("Inconnu", 0l);
	}
	
	// Pas utile de mettre des "getter" ici (final)
	@XmlElement
	public final Long unites;

	@XmlElement
	public final String libelle;
	
}
