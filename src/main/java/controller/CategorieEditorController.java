package controller;

import comptoirs.model.dao.CategorieFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Categorie;
import form.CategorieForm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

@Controller
@Path("categorieEditor")
@View("categorieEditor.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class CategorieEditorController {
	@Inject
	CategorieFacade dao;

	@Inject
	BindingResult formValidationErrors;
	
	@Inject
	Models models;

	@GET
	public void show() {
		models.put("categories", dao.findAll());
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.ALL)	
	public void create(@Valid @BeanParam CategorieForm formData) {
		if ( ! formValidationErrors.isFailed()) { // Pas d'erreurs de saisie dans le formulaire
			// On crée la nouvelle catégorie
			Categorie nouvelle = new Categorie();
			nouvelle.setLibelle(formData.getLibelle());
			nouvelle.setDescription(formData.getDescription());
			// On l'enregistre dans la base
			try {
				dao.create(nouvelle);
			} catch (EJBException e) {
				// Erreur possible : il existe déjà une catégorie avec ce libellé
				Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
				// On pourrait examiner l'exception pour vérifier sa cause exacte
				models.put("databaseErrorMessage", "La catégorie '" + formData.getLibelle() + "' existe déjà");
			}
		}
		models.put("validationErrors", formValidationErrors);
		models.put("categories", dao.findAll());
	}	
}
