package logic.view;

import java.io.IOException;
import javafx.scene.layout.HBox;
import logic.view.graphicElements.GraphicElementInterface;
import logic.view.graphicElements.SimpleGraphicElement;



public class HomePage extends Page{
	public HomePage() throws IOException {
		createPage();		
	}

	@Override
	public void createPage() throws IOException {
		GraphicElementInterface nav = new SimpleGraphicElement("../resources/NavbarView.fxml");
		GraphicElementInterface hm = new SimpleGraphicElement("../resources/HomeMenuView.fxml");
		GraphicElementInterface hb = new SimpleGraphicElement("../resources/HomeBoxView.fxml");
		//SplitPane hbox = new SplitPane(hm.draw(),hb.draw());
		//hbox.setOrientation(HORIZONTAL);
		HBox hbox = new HBox(hm.draw(),hb.draw());
	
		
		this.getChildren().add(nav.draw());
		this.getChildren().add(hbox);
		
	}
}
