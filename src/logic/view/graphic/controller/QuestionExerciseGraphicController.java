package logic.view.graphic.controller;

import java.io.IOException;


import execption.QuestionException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import logic.bean.QuestionBean;
import logic.controller.InsertQuestionController;
import logic.model.QuestionExerciseFactory;
import logic.model.QuestionFactory;
import logic.model.QuestionType;
import logic.view.AlertControl;
import logic.view.NamePage;

public class QuestionExerciseGraphicController extends GraphicController implements QuestionGraphicInterface {
	
	private QuestionFactory factory;
	private QuestionBean qBean;
	@FXML private Label message;
	@FXML private TextArea title;
	@FXML private TextArea body;
	@FXML private TextArea foto;
	private String subject;
	

	
	public QuestionExerciseGraphicController(String param) {
		this.factory = new QuestionExerciseFactory();
		this.subject = param;
	}

	@Override
	public void commit() throws QuestionException  {
	
		this.qBean = this.factory.createBean();
		this.qBean.setType(QuestionType.EXERCISE);
		
		if(title.getText().isEmpty() ) {
			this.message.setText("Please enter a title");
			
		}
		else if(body.getText().isEmpty()) {
			this.message.setText("Please the body");
		}
		else {
			this.message.setText("Starting save");
			
			try {
				this.qBean.setTitle(title.getText());
				this.qBean.getClass().getMethod("setText", String.class).invoke(this.qBean,this.body.getText());
				this.qBean.getClass().getMethod("setImage", String.class).invoke(this.qBean,this.foto.getText());
			}
			catch(ReflectiveOperationException e){
				this.message.setText("Sorry some error");
				throw new QuestionException(e.getMessage());
			}
			
			try {
				InsertQuestionController controller = new InsertQuestionController(this.factory,this.qBean);
				controller.startSave(this.subject);
				
			}
			catch(QuestionException e){
				AlertControl.infoBox("error on save DB", "ERROR");
				
				this.message.setText("Error on save");
			}
			this.message.setText("finito");
		}
		
	}
	
	@Override
	public void back() throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}
}
