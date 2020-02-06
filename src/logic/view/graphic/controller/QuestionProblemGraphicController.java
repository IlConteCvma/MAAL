package logic.view.graphic.controller;

import java.io.IOException;

import logic.bean.QuestionBean;
import logic.controller.InsertQuestionController;
import logic.controller.QuestionProblemController;
import logic.model.QuestionFactory;
import logic.model.QuestionProblemFactory;
import logic.view.NamePage;

public class QuestionProblemGraphicController extends GraphicController implements QuestionGraphicInterface{
	
	private QuestionFactory factory;
	private QuestionBean qBean;
	
	
	public QuestionProblemGraphicController() {
		this.factory = new QuestionProblemFactory();
	}
	
	

	@Override
	public void commit() {
		this.qBean = this.factory.createBean();
		//riempio il bean adeguatamente
		InsertQuestionController controller = new QuestionProblemController(this.factory,this.qBean);
		controller.newQuestion();
	}
	
	@Override
	public void back() throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}

}
