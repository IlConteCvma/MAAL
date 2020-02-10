package logic.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import execption.QuestionException;
import logic.bean.QuestionBean;
import logic.bean.SubjectBean;
import logic.model.Question;
import logic.model.QuestionFactory;
import logic.model.QuestionType;
import logic.model.SingletonConnectionDB;
import logic.model.Subject;
import logic.model.Dao.QuestionDao;
import logic.model.Dao.SubjectDao;

public class InsertQuestionController {
	protected QuestionBean dataBean;
	protected Question question;
	protected QuestionDao qDao;
	
	
	public InsertQuestionController(){
		
	}
	
	public InsertQuestionController(QuestionFactory factory,QuestionBean dataBean ) {
		this.dataBean = dataBean;
		this.question = factory.createQuestion();
		this.qDao= new QuestionDao();
		
	}
	
	public  void startSave() throws QuestionException {
		
		this.question.solved = false;
		
		try {
			this.question.id = this.qDao.getNewId() ;
		} catch (SQLException e) {
			throw new QuestionException("SQL problem");
		}
		
		this.question.setTitle(this.dataBean.getTitle());
		
		switch(this.dataBean.getType()) {
		
			case EXERCISE:
				try {
					saveText();
					
				}
				catch(ReflectiveOperationException e) {
					throw new QuestionException("Error in reflection for text");
				}
				try {
					saveImage();
					
				}
				catch(ReflectiveOperationException e) {
					throw new QuestionException("Error in reflection for image");
				}
				
				try {
					saveQuestion();
				}
				catch(ReflectiveOperationException e) {
					e.printStackTrace();
					throw new QuestionException("Error in reflection for save");
				}
				
				
			case PROBLEM:
				try {
					saveText();
				}
				catch(ReflectiveOperationException e) {
					
					throw new QuestionException("Error in reflection for text");
				}
			
		}
		
		
		
		
		}
	
	
	public ArrayList<SubjectBean> getSubject() {
		ArrayList<SubjectBean> sBean = new ArrayList<SubjectBean>() ;
		
		ArrayList<Subject> subj = SubjectDao.getSubjectOfStudent(SingletonConnectionDB.getStudent());
		
		return sBean;
	}
	
	
	private void saveText() throws ReflectiveOperationException {
		
		Object returned = this.dataBean.getClass().getMethod("getText").invoke(this.dataBean);
		this.question.getClass().getMethod("setText", String.class).invoke(this.question, (String)returned);
		
	}
	
	private void saveImage()throws ReflectiveOperationException {
		
		Object returned = this.dataBean.getClass().getMethod("getText").invoke(this.dataBean);
		this.question.getClass().getMethod("setText", String.class).invoke(this.question, (String)returned);
	}
	
	private void saveQuestion() throws ReflectiveOperationException{
		this.qDao.saveOnDBFake(this.question, this.dataBean.getType());
		//this.qDao.saveOnDB(this.question, this.dataBean.getType());
		//this.qDao.getClass().getMethod("saveOnDB", Question.class,QuestionType.class).invoke(this.qDao, this.question,this.dataBean.getType());
	}
	
	
}
