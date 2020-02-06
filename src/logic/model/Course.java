package logic.model;

import java.util.Vector;

public class Course {
	
	private String nameOfCourse;
	private Vector<Subject> subjectOfCourse;
	private Vector<Student> studentOfCourse;
	
	public Course(String nameOfCourse, Vector<Subject> subjectOfCourse, Vector<Student> studentOfCourse) {
		this.nameOfCourse = nameOfCourse;
		this.subjectOfCourse = subjectOfCourse;
		this.studentOfCourse = studentOfCourse;
	}
	
	public String getNameOfCourse() {
		return this.nameOfCourse;
	}
	
	public Vector<Subject> getSubjectOfCourse(){
		return this.subjectOfCourse;
	}
	
	public Vector<Student> getStudentOfCourse(){
		return this.studentOfCourse;
	}
}
