package logic.controller;

import logic.bean.InsertQuestionBean;
import logic.model.Question;
import logic.model.QuestionFactory;
import logic.model.Dao.QuestionDao;

public class InsertQuestionController {
	
	private InsertQuestionBean dataBean;
	private Question question;
	private QuestionDao qDao;
	//private QuestionFactory factory;
	
	public InsertQuestionController(QuestionFactory factory,InsertQuestionBean dataBean ) {
		this.dataBean = dataBean;
		this.question = factory.createQuestion();
		this.qDao = factory.createDao();
	}
	
	public void newQuestion() {
		
	}
}
