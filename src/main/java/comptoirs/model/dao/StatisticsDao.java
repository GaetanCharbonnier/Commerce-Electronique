package comptoirs.model.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StatisticsDao {
	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	public List unitesVenduesParCategorie() {
		Query query = em.createNamedQuery("Categorie.unitesVendues");
		List results = query.getResultList();
		return results;
	}	
}
