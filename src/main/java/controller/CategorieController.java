package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.entity.Categorie;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@Controller
@Path("categories")
@View("showAllCategories.jsp")
public class CategorieController {
	@Inject // Le DAO généré par netBeans
	CategorieFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		List<Categorie> toutesLesCategories = dao.findAll();
		models.put("categories", toutesLesCategories);
	}
}
