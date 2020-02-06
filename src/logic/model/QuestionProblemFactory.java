package logic.model;

import logic.model.Dao.QuestionDao;
import logic.model.Dao.QuestionProblemDao;

public class QuestionProblemFactory extends QuestionFactory {

	@Override
	public QuestionDao createDao() {
		return new QuestionProblemDao();
	}

	@Override
	public Question createQuestion() {
		return new QuestionProblem();
	}

}
