package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.Session;
import logic.model.Address;
import logic.model.SingletonConnectionDB;
import logic.model.Student;
import logic.model.TypeVehicle;
import logic.model.Vehicle;
import logic.model.queries.StudentQueries;

public class StudentDao {

	private StudentDao() {
		throw new IllegalStateException("Utility class");
	}

	public static Student findStudentLog(String possibleUsername, String possiblePassword) throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		Student studLog = null;
		ResultSet rs = null;

		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
			if (conn== null) {
				throw new SQLException();
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = StudentQueries.selectStudent(stmt, possibleUsername, possiblePassword);
			if (rs.first()) {
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
				Address addressStudent = new Address(address, streetNumber, city);

				studLog = new Student(name, surname, username, password, addressStudent, vehicleStudent);
				Session.getSession().setStudent(studLog);
			}

			rs.close();
		} catch (SQLException e) {
			throw e;
		} finally {

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				SingletonConnectionDB.close();
				SingletonConnectionDB.increaseCount();
			}
		}

		return studLog;
	}
	
	public static Student findStudent(String Username) throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		Student studLog = null;
		ResultSet rs = null;

		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
			if (conn== null) {
				throw new SQLException();
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = StudentQueries.selectSingleStudent(stmt, Username);
			if (rs.first()) {
				rs.first();
				
				String name = rs.getString("Nome");
				String surname = rs.getString("Cognome");
				String username = rs.getString("Username");
				String password = null;
				String address = rs.getString("Indirizzo");
				String streetNumber = rs.getString("Civico");
				String city = rs.getString("Citta");
				String typeVehicle = rs.getString("Veicolo");

				Vehicle vehicleStudent = new Vehicle(TypeVehicle.valueOf(typeVehicle));
				Address addressStudent = new Address(address, streetNumber, city);

				studLog = new Student(name, surname, username, password, addressStudent, vehicleStudent);
				Session.getSession().setStudent(studLog);
			}

			rs.close();
		} catch (SQLException e) {
			throw e;
		} finally {

			if (stmt != null) {
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