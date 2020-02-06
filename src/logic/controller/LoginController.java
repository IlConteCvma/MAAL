package logic.controller;

import java.sql.SQLException;

import logic.bean.StudentBean;
import logic.model.Student;
import logic.model.Dao.StudentDao;

public class LoginController {
		
	public boolean login(StudentBean potentialStud) throws SQLException {
		boolean found = false;
		Student stud = StudentDao.findStudentLog(potentialStud);
		
		if(stud != null) {
			found = true;
		}
		
		return found;
	}
	
}
