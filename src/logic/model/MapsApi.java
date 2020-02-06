package logic.model;

import java.io.IOException;
import java.util.Vector;
import org.json.*;

public class MapsApi{

	private static RequestHttpApi connection = new RequestHttpApi();
	private static String apikey = "AIzaSyBxqvZv-6yD5NY-JGuO8kuSqdxHNYj3Fs0";
    
    public static Vector<Double> getPosition() throws IOException{
    	String url_request = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=University of Tor Vergata&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&key=" + apikey;
    	System.out.println(url_request);
    	String response = connection.sendRequest(url_request);
    	JSONObject positionObj = new JSONObject(response);
    	JSONArray arr = positionObj.getJSONArray("candidates");
    	JSONObject post_id = arr.getJSONObject(0).getJSONObject("geometry").getJSONObject("viewport").getJSONObject("southwest");
    	Double lat = (Double)post_id.get("lat");
    	Double lng = (Double)post_id.get("lng");
    	Vector<Double> position = new Vector<Double>();
    	position.add(lng);
    	position.add(lat);
		return position;
    	
    }
    
    public static Double calculateDistance(double lat1,double lat2,double lon1,double lon2) {
    	
    	double R = 6371e3 / 1000; // km
    	double d1 = lat1 * 3.14 / 180;
    	double d2 = lat2 * 3.14 / 180;
    	double d3 = (lat2-lat1) * 3.14 / 180;
    	double d4 = (lon2-lon1) * 3.14 / 180;

    	double a = Math.sin(d3/2) * Math.sin(d3/2) +
    	        Math.cos(d1) * Math.cos(d2) *
    	        Math.sin(d4/2) * Math.sin(d4/2);
    	
    	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    	double d = R * c;
    	
		return d;
    }
    
    public static double calculateTime() {
    	double speed = 30*0.016; //0.016 = 1/60
    	double distance = MapsApi.calculateDistance(41.85, 41.90, 12.63, 12.60);
    	double time = (distance / speed);
    	return time;
    }

}
