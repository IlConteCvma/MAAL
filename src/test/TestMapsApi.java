package test;
/*
 * 
 * Alessandro Chillotti
 * Check the distance as the crow flies between tho points.
 */


import org.junit.Test;

import logic.model.MapsApi;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TestMapsApi {
	
		//Check the value take by google maps with misure distance
		private static final double EXPECTEDDISTANCE = 16.86;
	
		@Test
		public void testCalculateDistanceBetweenStadiumUniversity() {
			MapsApi mapCtrl = new MapsApi();
			List<Double> origin = new ArrayList<>();
			//Set Olympic stadium coordinates
			origin.add(41.94);
			origin.add(12.48);
			//Set university coordinates
			List<Double> destination = new ArrayList<>();
			destination.add(41.85);
			destination.add(12.62);
			double output = mapCtrl.calculateDistance(origin, destination);
			assertEquals(EXPECTEDDISTANCE, output, 1);
		}	
		
}
