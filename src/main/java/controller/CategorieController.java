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
	@Inject
	CategorieFacade facade;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("categories", facade.findAll());
	}

}
