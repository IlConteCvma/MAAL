package logic.controller;

import logic.bean.QuestionBean;
import logic.model.QuestionFactory;

public class QuestionExerciseController extends InsertQuestionController {

	public QuestionExerciseController(QuestionFactory factory, QuestionBean dataBean) {
		super(factory, dataBean);
	}

	@Override
	public void newQuestion() {
		//riempio la question
		//this.question = this.dataBean bla bla bla

	}

}
