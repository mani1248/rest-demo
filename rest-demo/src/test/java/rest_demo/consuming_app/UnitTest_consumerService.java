package rest_demo.consuming_app;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import rest_demo.consuming_app.ServiceConsumer;

public class UnitTest_consumerService {

	StatePOJO spojo;
	@Test
	public void testValidURL() {
		spojo = ServiceConsumer.consumerService("http://services.groupkt.com/state/get/USA/MN");
		Assert.assertTrue(spojo.getCapital().matches("St. Paul"));
		Assert.assertTrue(spojo.getLargestCity().matches("Minneapolis"));
	}
	
	@Test
	public void testInvalidURL1() {
		spojo = ServiceConsumer.consumerService("http://services.groupkt.com/state/get/USA/");
		Assert.assertTrue(spojo.getCapital() == null);
		Assert.assertTrue(spojo.getLargestCity() == null);
	}

	@Test
	public void testInvalidURL2() {
		spojo = ServiceConsumer.consumerService("http://services.groupkt.com/state/get/USA/all");
		Assert.assertTrue(spojo.getCapital() == null);
		Assert.assertTrue(spojo.getLargestCity() == null);
	}
	
	@Test
	public void testInvalidURL3() {
		spojo = ServiceConsumer.consumerService("google.com");
		Assert.assertTrue(spojo.getCapital() == null);
		Assert.assertTrue(spojo.getLargestCity() == null);
	}
}
