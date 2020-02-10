package logic.view;

import java.io.IOException;

import javafx.scene.layout.HBox;
import logic.view.graphic.elements.GraphicElementInterface;
import logic.view.graphic.elements.NavbarElement;
import logic.view.graphic.elements.SimpleGraphicElement;

public class HomeTimePage extends Page {

	public HomeTimePage() throws IOException {
		createPage();		
	}
	
	@Override
	public void createPage() throws IOException {
		GraphicElementInterface nav = new NavbarElement();
		GraphicElementInterface hm = new SimpleGraphicElement("../../resources/HomeMenuView.fxml");
		GraphicElementInterface hb = new SimpleGraphicElement("../../resources/TimeToExitView.fxml");
		//SplitPane hbox = new SplitPane(hm.draw(),hb.draw());
		//hbox.setOrientation(HORIZONTAL);
		HBox hbox = new HBox(hm.draw(),hb.draw());
		hbox.setSpacing(0);
		
		this.getChildren().add(nav.draw());
		this.getChildren().add(hbox);

	}

}
