package logic.view;

import java.io.IOException;

import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.SimpleGraphicElement;

public class QuestionProblemPage extends Page {

	public QuestionProblemPage() throws IOException {
		createPage();		
	}

	@Override
	public void createPage() throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		GraphicElementInterface qPage = new SimpleGraphicElement("../../resources/QuestionProblemView.fxml");
		
		this.getChildren().add(nav.draw());
		this.getChildren().add(qPage.draw());
		
	}
}
