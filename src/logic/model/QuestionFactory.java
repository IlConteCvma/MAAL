package logic.model;

import logic.model.Dao.QuestionDao;

public abstract class QuestionFactory {
	public abstract QuestionDao createDao();
	public abstract Question createQuestion();
}
