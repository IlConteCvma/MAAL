package logic.view.graphic.controller;

import logic.bean.InsertQuestionBean;
import logic.controller.InsertQuestionController;
import logic.model.QuestionFactory;

public class InsertQuestionGraphicController {
	private QuestionFactory factory;
	private InsertQuestionBean dataBean;
	
	public InsertQuestionGraphicController() {
		this.dataBean = new InsertQuestionBean();
	}
	
	
	/*In base al tipo selezionato genero la factory corretta
	//click 1
	//this.factory = new QuestionProblemFactory();
	//click 2*/
	//this.factory = new QuestionExerciseFactory();
	
	//click attiva il controller
	
	public void commit() {
		InsertQuestionController controller = new InsertQuestionController(factory,dataBean);
		controller.newQuestion();
	}
}
