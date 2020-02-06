package logic.controller;

import logic.bean.QuestionBean;
import logic.model.QuestionFactory;

public class QuestionProblemController extends InsertQuestionController {

	public QuestionProblemController(QuestionFactory factory, QuestionBean dataBean) {
		super(factory, dataBean);
	}

	@Override
	public void newQuestion() {
		//riempio la question
		//this.question = this.dataBean bla bla bla
		
	}

}
