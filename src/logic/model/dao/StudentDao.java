package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.Session;
import logic.model.SingletonConnectionDB;
import logic.model.Student;
import logic.model.TypeVehicle;
import logic.model.Vehicle;
import logic.model.queries.StudentQueries;

public class StudentDao {	

    public static Student findStudentLog(String possibleUsername, String possiblePassword) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        Student studLog = null;
        
        try {
        	
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	
            ResultSet rs = StudentQueries.selectStudent(stmt, possibleUsername, possiblePassword);

            if (!rs.first()){
            	studLog = null;
            }else {
            	rs.first();
            	SingletonConnectionDB.increaseCount();
            	String name = rs.getString("Nome");
            	String surname = rs.getString("Cognome");
            	String username = rs.getString("Username");
            	String password = rs.getString("Password");
            	String address = rs.getString("Indirizzo");
            	String streetNumber = rs.getString("Civico");
            	String city = rs.getString("Citta");
            	String typeVehicle = rs.getString("Veicolo");
            	
            	Vehicle vehicleStudent = new Vehicle(TypeVehicle.valueOf(typeVehicle));
            	
            	studLog = new Student(name,surname,username,password,address,streetNumber, city,vehicleStudent);
            	Session.getSession().setStudent(studLog);
            }
            
            rs.close();
        } finally {     
        	if(stmt != null){
        		stmt.close();
        	}
            if (conn != null) {
				SingletonConnectionDB.close();
				SingletonConnectionDB.increaseCount();
			}
        }
	
        return studLog;
    }
}