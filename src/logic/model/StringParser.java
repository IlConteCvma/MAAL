package logic.model;

public class StringParser {

	public String parseStringMaps(Address address) {
		StringBuilder bld = new StringBuilder();
		bld.append("https://google.com/maps/dir/");
		String street = address.getStreet();
		for(int i=0;i<street.length();i++) {
			if(street.charAt(i) == ' ') {
				bld.append('+');
			}else {
				bld.append(street.charAt(i));
			}
		}
		
		bld.append(",+" + address.getStreetNumber() + ",+" + address.getCity() + "/Via+del+Politecnico,+1,+00100+Roma+RM");
		
		
		return bld.toString();
	}
	
}
