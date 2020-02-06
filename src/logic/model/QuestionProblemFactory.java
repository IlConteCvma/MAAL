package logic.model;

import logic.bean.QuestionBean;
import logic.bean.QuestionProblemBean;
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

	@Override
	public QuestionBean createBean() {
		return new QuestionProblemBean();
	}

}
