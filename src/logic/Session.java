package logic;


import logic.model.Student;

public class Session {
	private static Session instance = null;
	private Student studentLog;
	private String subject;
	
	
	protected Session(){
		
	}
	
	public synchronized static Session getSession() {
		if (Session.instance == null) {
			Session.instance = new Session();
			}
		return instance;
	}

	public Student getStudent() {
		return this.studentLog;
	}

	public void setStudent(Student student) {
		this.studentLog = student;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
