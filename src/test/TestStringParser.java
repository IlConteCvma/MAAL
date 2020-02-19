package test;

/*
 * 
 * Alessandro Chillotti
 * Check the url created for google maps.
 */


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import logic.model.Address;
import logic.model.StringParser;

public class TestStringParser {
	
	private static final String EXPECTEDURL = "https://google.com/maps/dir/Via+Roma,+12,+Napoli/Via+del+Politecnico,+1,+00100+Roma+RM";
	private static final String EXPECTEDERRORURL = "Error";

	@Test
	public void testStringParsedOnGeneralCase() {
		StringParser strCtrl = new StringParser();
		//Set a specific address
		Address addrTest = new Address("Via Roma","12","Napoli");
		String output = strCtrl.parseStringMaps(addrTest);
		//Check the value take by google maps with misure distance
		assertEquals(EXPECTEDURL, output);
	}
	
	@Test
	public void testStringParsedWithAnErroNumberOfStreet() {
		StringParser strCtrl = new StringParser();
		//Set a specific address with number of street wrong
		Address addrTest = new Address("Via 12","ciao","Napoli");
		String output = strCtrl.parseStringMaps(addrTest);
		//Check the value take by google maps with misure distance
		assertEquals(EXPECTEDERRORURL, output);
	}
	
}
