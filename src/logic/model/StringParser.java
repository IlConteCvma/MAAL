package logic.model;

import logic.Session;

public class StringParser {

	public String parseStringMaps() {
		Student studLog = Session.getSession().getStudent();
		String urlParsed = "https://google.com/maps/dir/";
		String address = studLog.getAddress();
		
		for(int i=0;i<address.length();i++) {
			if(address.charAt(i) == ' ') {
				urlParsed = urlParsed + '+';
			}else {
				urlParsed = urlParsed + address.charAt(i);
			}
		}
		
		urlParsed = urlParsed + ",+" + studLog.getStreetNumber() + ",+" + studLog.getCity() + "/Via+del+Politecnico,+1,+00100+Roma+RM";
		
		return urlParsed;
	}
	
}
