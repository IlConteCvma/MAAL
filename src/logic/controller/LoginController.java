package logic.controller;

import logic.model.Student;
import logic.model.StudentDao;

public class LoginController {
	
	private Student stud;
		
	public void login(String username, String password) throws Exception {
		stud = StudentDao.findStudentLog(username, password);
	}
	
}
