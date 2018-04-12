package rest_demo.consuming_app;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class StateResource {
	/*
	 * This methods call the service consuming method by appending the state abbreviation to the base url
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public static StatePOJO getCities(String st) {
		StatePOJO state = ServiceConsumer.consumerService("http://services.groupkt.com/state/get/USA/" + st);
		return state;
	}
	
}
