package logic.controller;

import logic.bean.UserBean;
import logic.model.Address;
import logic.model.Student;
import logic.model.Vehicle;

public class RegistrationController {
	
	public RegistrationController(UserBean newUser) {
		Address addressUser = new Address(newUser.getAddress(),newUser.getNumberOfStreet(),newUser.getCity());
		Vehicle vehicleUser = new Vehicle(newUser.getVehicle());
		Student newStudent = new Student(newUser.getName(),newUser.getSurname(),newUser.getUsername(),newUser.getPassword(),addressUser,vehicleUser);
	}
	
}
