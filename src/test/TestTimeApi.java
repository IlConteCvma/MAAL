package test;
/*
 * Marco Calavaro
 * 
 */


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import logic.model.TimeApi;

public class TestTimeApi {

	private static final String EXPECTEDHOUR = "12:48";
	private static final long EXPECTEDDIFF = 5;
	
	@Test
	public void testTimeAddOnGeneralCase() {
		//test fail if EXPECTEDHOUR is not NOW + 10
		TimeApi timeCtrl = new TimeApi();
		//add 10 minute
		String output = timeCtrl.timeAdd(10);
		//hour now + 10
		assertEquals(EXPECTEDHOUR, output);
	}
	

	@Test
	public void testGetTimeMinuteDiffOnSpecificCase() {
		TimeApi timeCtrl = new TimeApi();
		//SpecificCase with time 19:55 and 19:50;
		long result = timeCtrl.getTimeMinuteDiff("19:55", "19:50");
		assertEquals(EXPECTEDDIFF, result,0);
	}
}
