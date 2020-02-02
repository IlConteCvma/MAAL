package logic.controller;

import logic.model.StudentDao;

public class LoginController {
	
	StudentDao sd = new StudentDao();
	
	public boolean findStudent(String username, String password) throws Exception {
		boolean found = false;
		
		if(StudentDao.findStudentLog(username, password) != null) {
			found = true;
		}
		
		return found;
	}
	
}
