package logic.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import logic.view.graphic.controller.GraphicController;
import logic.view.graphic.controller.QuestionExerciseGraphicController;
import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.NoControllerGrapichElement;



public class QuestionExercisePage extends Page{
	
	public QuestionExercisePage() throws IOException {
				
	}
	
	public QuestionExercisePage(String param) throws IOException{
		createPage(param);
	}

	
	private void createPage(String param) throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		NoControllerGrapichElement qPage = new NoControllerGrapichElement("../../resources/QuestionExerciseView.fxml");
		GraphicController controller = new QuestionExerciseGraphicController(param);
		
		
		FXMLLoader load =qPage.draw();
		load.setController(controller);
		AnchorPane pane = load.load();

		this.getChildren().add(nav.draw());
		this.getChildren().add(pane);
		
		
	}

	@Override
	protected void createPage() throws IOException {
		//not use		
	}



}
