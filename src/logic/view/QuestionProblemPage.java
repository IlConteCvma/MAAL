package logic.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import logic.view.graphic.controller.GraphicController;
import logic.view.graphic.controller.QuestionExerciseGraphicController;
import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.NoControllerGrapichElement;


public class QuestionProblemPage extends Page {
	
	public QuestionProblemPage() throws IOException {
		createPage();
	}

	public QuestionProblemPage(String param) throws IOException{
		createPage(param);
	}

	
	public void createPage(String param) throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		NoControllerGrapichElement qPage = new NoControllerGrapichElement("../../resources/QuestionProblemView.fxml");		
		GraphicController controller = new QuestionExerciseGraphicController(param);
		
		FXMLLoader load =qPage.draw();
		load.setController(controller);
		AnchorPane pane = load.load();
		
		this.getChildren().add(nav.draw());
		this.getChildren().add(pane);
		
	}


	@Override
	protected void createPage() throws IOException {
		
	}
}
