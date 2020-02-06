package logic.view.graphic.controller;

import java.io.IOException;

import logic.bean.QuestionBean;
import logic.controller.InsertQuestionController;
import logic.controller.QuestionExerciseController;
import logic.model.QuestionExerciseFactory;
import logic.model.QuestionFactory;
import logic.view.NamePage;

public class QuestionExerciseGraphicController extends GraphicController implements QuestionGraphicInterface {
	
	private QuestionFactory factory;
	private QuestionBean qBean;
	
	public QuestionExerciseGraphicController() {
		this.factory = new QuestionExerciseFactory();
	}

	@Override
	public void commit() {
		this.qBean = this.factory.createBean();
		//riempio il bean adeguatamente
		InsertQuestionController controller = new QuestionExerciseController(this.factory,this.qBean);
		controller.newQuestion();
	}
	
	@Override
	public void back() throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}
}
