package logic.controller;

import logic.bean.QuestionBean;
import logic.model.Question;
import logic.model.QuestionFactory;
import logic.model.Dao.QuestionDao;

public abstract class InsertQuestionController {
	protected QuestionBean dataBean;
	protected Question question;
	protected QuestionDao qDao;
	
	
	public InsertQuestionController(QuestionFactory factory,QuestionBean dataBean ) {
		this.dataBean = dataBean;
		this.question = factory.createQuestion();
		this.qDao = factory.createDao();
	}
	
	public abstract void newQuestion(); 
	
}
