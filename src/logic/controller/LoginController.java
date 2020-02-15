package logic.controller;

import java.sql.SQLException;

import execption.UserException;
import logic.Session;
import logic.bean.StudentBean;
import logic.model.Student;
import logic.model.dao.StudentDao;

public class LoginController {
		
	public void login(StudentBean potentialStud) throws SQLException, UserException {
		String username = potentialStud.getUsername();
		String password = potentialStud.getPassword();
		Student stud = StudentDao.findStudentLog(username,password);
		
		if(stud != null) {
			Session.getSession().setStudent(stud);
		}else {
			throw new UserException();
		}
		
	}
	
}
