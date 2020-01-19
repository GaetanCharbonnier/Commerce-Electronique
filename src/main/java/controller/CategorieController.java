package controller;

import comptoirs.model.dao.CategorieFacade;
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
		models.put("categories", dao.findAll());
	}
}
