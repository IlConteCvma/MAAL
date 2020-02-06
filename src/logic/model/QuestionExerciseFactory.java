package logic.model;

import logic.bean.QuestionBean;
import logic.bean.QuestionExerciseBean;
import logic.model.Dao.QuestionDao;
import logic.model.Dao.QuestionExerciseDao;

public class QuestionExerciseFactory extends QuestionFactory {

	@Override
	public QuestionDao createDao() {
		return new QuestionExerciseDao();
	}

	@Override
	public Question createQuestion() {
		return new QuestionExercise();
	}

	@Override
	public QuestionBean createBean() {
		return new QuestionExerciseBean();
	}

}
