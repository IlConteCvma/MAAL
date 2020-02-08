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
import logic.view.NamePage;

public class QuestionExerciseGraphicController extends GraphicController implements QuestionGraphicInterface {
	
	private QuestionFactory factory;
	private QuestionBean qBean;
	@FXML private Label message;
	@FXML private TextArea title;
	@FXML private TextArea body;
	@FXML private TextArea foto;
	
	public QuestionExerciseGraphicController() {
		//this.message = ottieni la materia dalla sessione
		this.factory = new QuestionExerciseFactory();
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
				controller.startSave();
			}
			catch(QuestionException e){
				e.printStackTrace();
				this.message.setText("Error on save");
			}
			finally {
				//o azioni di pulizia o torno indietro
			}
		}
		
		
		
		
		/*
		Method methodToBeCalled = this.qBean.getClass().getMethod("setText",String.class);
		methodToBeCalled.invoke(this.qBean, "IO SONO PIPPO");
		
		Class c = this.qBean.getClass();
		System.out.println(c.getName());
		
		Method methodToBeCalled1 = this.qBean.getClass().getMethod("getText");
		Object returnedObject = methodToBeCalled1.invoke(this.qBean);
		System.out.println((String)returnedObject);
		*/
	}
	
	@Override
	public void back() throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}
}
