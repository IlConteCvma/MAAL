package logic.controller;

import java.sql.SQLException;

import logic.bean.StudentBean;
import logic.model.Student;
import logic.model.dao.StudentDao;

public class LoginController {
		
	public boolean login(StudentBean potentialStud) throws SQLException {
		boolean found = false;
		String username = potentialStud.getUsername();
		String password = potentialStud.getPassword();
		Student stud = StudentDao.findStudentLog(username,password);
		
		if(stud != null) {
			found = true;
		}
		
		return found;
	}
	
}
