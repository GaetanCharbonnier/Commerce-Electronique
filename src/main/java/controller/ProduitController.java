package controller;

import comptoirs.model.dao.CategorieFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Produit;
import java.math.BigDecimal;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Controller
@Path("produits")
public class ProduitController {
	@Inject
	ProduitFacade facadeP;

	@Inject
	CategorieFacade facadeC;
	
	@Inject
	Models models;

	@GET
	@View("showAllProduits.jsp")
	public void show() {
		models.put("produits", facadeP.findAll());
	}
	
	@GET
	@Path("create")
	@View("creationProduit.jsp")
	public void create() {
		// On va chercher la liste des catégories pour les afficher dans la liste de choix
		models.put("categories", facadeC.findAll());
	}
	
	@POST
	@Path("create")
	public String create(
		@FormParam("nom") String nom,  
		@FormParam("codeCategorie") Integer codeCategorie,
		@FormParam("prixUnitaire") BigDecimal prixUnitaire ) 
	{
		// TODO : ce code est trop compliqué, fait trop de manipulations à la BD
		// Il vaudrait mieux en faire une méthode dans un DAO
		// TODO : gestion des exceptions
		// Et si la catégorie n'existe pas ?
		// Et si la création du produit échoue (nom en double, par exemple) ?
		Categorie categorie = facadeC.find(codeCategorie);
		Produit nouveau = new Produit();
		nouveau.setNom(nom);
		nouveau.setPrixUnitaire(prixUnitaire);
		nouveau.setCategorie(categorie);
		
		facadeP.create(nouveau);
		
		return "redirect:/produits";
	}
}
