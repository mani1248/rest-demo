package rest_demo.consuming_app;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;
import rest_demo.execute.Execute;

public class UnitTest_convertToAbbr extends TestCase {

	String result;
	@Test
	public void testRandomString() {
		result = Execute.convertToAbbr("Some text");
		Assert.assertTrue(result == null);
	}
	
	@Test
	public void testLowercaseStateName() {
		result = Execute.convertToAbbr("minnesota");
		Assert.assertTrue(result == "MN");
	}
	
	@Test
	public void testUppercaseStateName() {
		result = Execute.convertToAbbr("MINNESOTA");
		Assert.assertTrue(result == "MN");
	}
	
	@Test
	public void testAlphaNumericInput() {
		result = Execute.convertToAbbr("132AA");
		Assert.assertTrue(result == null);
	}
	
}
