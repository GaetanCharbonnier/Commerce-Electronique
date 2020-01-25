package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service/longRequest")
public class LongService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String longRequest() throws InterruptedException {
		Thread.sleep(3000); // On attend 3 secondes
		return "Long request is finished";
	}
}
