package logic;


import logic.model.Lesson;
import logic.model.Student;

public class Session {
	private static Session instance = null;
	private Student studentLog;
	private String subject;
	private Lesson nextLesson;
	private int priority;
	private double minutes;
	
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
	
	public Lesson getNextLesson() {
		return nextLesson;
	}

	public void setNextLesson(Lesson nextLesson) {
		this.nextLesson = nextLesson;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

}
