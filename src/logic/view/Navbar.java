package logic.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import logic.view.graphic.controller.NavbarGraphicController;


public class Navbar extends Page{
	
	private NavbarGraphicController controller;
	
	public Navbar() throws IOException{
		controller  = new NavbarGraphicController();
		createPage();
	}
	

	
	public NavbarGraphicController controller() {
		return controller;	
	}
	
	protected void createPage() throws IOException {
	
		FXMLLoader load = new FXMLLoader(getClass().getResource("resources/NavbarView.fxml"));	
		load.setController(controller);
		AnchorPane pane = load.load();
		this.getChildren().add(pane) ;
		
	}
}
