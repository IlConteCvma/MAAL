package logic.view;

import java.io.IOException;

import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.SimpleGraphicElement;


public class QuestionExercisePage extends Page{
	public QuestionExercisePage() throws IOException {
		createPage();		
	}

	@Override
	public void createPage() throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		GraphicElementInterface qPage = new SimpleGraphicElement("../../resources/QuestionExerciseView.fxml");
		
		this.getChildren().add(nav.draw());
		this.getChildren().add(qPage.draw());
		
	}
}
