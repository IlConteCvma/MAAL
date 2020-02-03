package logic.controller;

import logic.model.Student;
import logic.model.StudentDao;

public class LoginController {
		
	public boolean login(String username, String password) throws Exception {
		boolean found = false;
		Student stud = StudentDao.findStudentLog(username, password);
		
		if(stud != null) {
			found = true;
		}
		
		return found;
	}
	
}
