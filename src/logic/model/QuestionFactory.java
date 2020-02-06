package logic.model;

import logic.bean.QuestionBean;
import logic.model.Dao.QuestionDao;

public abstract class QuestionFactory {
	public abstract QuestionDao createDao();
	public abstract Question createQuestion();
	public abstract QuestionBean createBean();
}
