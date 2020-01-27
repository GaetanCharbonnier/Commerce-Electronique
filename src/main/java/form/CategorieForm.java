package form;

import javax.mvc.binding.MvcBinding;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.io.Serializable;

public class CategorieForm implements Serializable {

	private static final long serialVersionUID = -3523783484400524581L;

	@MvcBinding @FormParam("libelle")
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Uniquement des lettres ou des chiffres")
	private String libelle;

	@MvcBinding @FormParam("description")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String description;

	// Getters, setters
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
