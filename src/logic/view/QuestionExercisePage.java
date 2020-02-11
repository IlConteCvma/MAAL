package logic.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import logic.MainClass;
import logic.view.graphic.controller.GraphicController;
import logic.view.graphic.controller.QuestionExerciseGraphicController;
import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.NoControllerGrapichElement;
import logic.view.graphic.elements.SimpleGraphicElement;


public class QuestionExercisePage extends Page{
	
	public QuestionExercisePage() throws IOException {
				
	}
	
	public QuestionExercisePage(String param) throws IOException{
		createPage(param);
	}

	
	public void createPage(String param) throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		NoControllerGrapichElement qPage = new NoControllerGrapichElement("../../resources/QuestionExerciseView.fxml");
		GraphicController controller = new QuestionExerciseGraphicController(param);
		
		
		FXMLLoader load =qPage.draw();
		// pane =FXMLLoader.load(getClass().getResource("resources/pippo.fxml"));
		load.setController(controller);
		//System.out.println(pane.getController().toString());
		AnchorPane pane = load.load();
		
		
		
		/*
		gc = new 
		FXMLLoader loader = nav.draw();
		loader.setController(gc);
		*/
		this.getChildren().add(nav.draw());
		this.getChildren().add(pane);
		
		//Scene scene = new Scene(root);
		//MainClass.getStage().setScene(scene);
		
	}

	@Override
	public void createPage() throws IOException {
		
		
	}
}
