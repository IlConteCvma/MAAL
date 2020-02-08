package logic.view.graphic.controller;

import java.io.IOException;

import execption.QuestionException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import logic.bean.QuestionBean;
import logic.controller.InsertQuestionController;
import logic.model.QuestionFactory;
import logic.model.QuestionProblemFactory;
import logic.model.QuestionType;
import logic.view.NamePage;

public class QuestionProblemGraphicController extends GraphicController implements QuestionGraphicInterface{
	
	private QuestionFactory factory;
	private QuestionBean qBean;
	@FXML private Label message;
	@FXML private TextArea title;
	@FXML private TextArea body;
	
	
	public QuestionProblemGraphicController() {
		//this.message = ottieni la materia dalla sessione
		this.factory = new QuestionProblemFactory();
	}
	
	

	@Override
	public void commit() throws QuestionException   {
		
	
		this.qBean = this.factory.createBean();
		this.qBean.setType(QuestionType.PROBLEM);
		
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
				
			}
			catch(ReflectiveOperationException e){
				this.message.setText("Sorry some error");
				throw new QuestionException(e.getMessage());
			}
			
			try {
				InsertQuestionController controller = new InsertQuestionController(this.factory,this.qBean);
				controller.startSave();
			}
			catch(QuestionException e){
				e.printStackTrace();
				this.message.setText("Error on save");
			}
			finally {
				this.message.setText("finito");
				//o azioni di pulizia o torno indietro
			}
		}
	}
	
	@Override
	public void back() throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}

}
