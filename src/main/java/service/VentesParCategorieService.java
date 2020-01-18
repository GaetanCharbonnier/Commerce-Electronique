package service;

import comptoirs.model.dao.StatisticsDao;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("unitesVenduesParCategorie")
public class VentesParCategorieService {

	@Inject
	StatisticsDao dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List unitesVenduesParCategorie() {
		return dao.unitesVenduesParCategorie();
	}
}
