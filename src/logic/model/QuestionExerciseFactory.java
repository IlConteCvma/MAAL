package logic.model;

import logic.bean.QuestionBean;
import logic.bean.QuestionExerciseBean;


public class QuestionExerciseFactory extends QuestionFactory {



	@Override
	public Question createQuestion() {
		return new QuestionExercise();
	}

	@Override
	public QuestionBean createBean() {
		return new QuestionExerciseBean();
	}

}
