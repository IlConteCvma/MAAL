package logic.model;

public class Student {
	
	private String name;
	private String surname;
	private String username;
	private String password;
	private String address;
	private String streetNumber;
	private String city;
	private Vehicle vehicle;
	
	
	public Student(String name, String surname, String username, String password, String address, String streetNumber, String city, Vehicle vehicle) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.vehicle = vehicle;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public String getStreetNumber() {
		return streetNumber;
	}
	public String getCity() {
		return city;
	}
	
}