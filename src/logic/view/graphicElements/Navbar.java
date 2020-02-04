package logic.view.graphicElements;


import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

import javafx.fxml.FXMLLoader;




public class Navbar {

	private  VBox root;
	
	public  VBox draw() throws IOException{
		root = new VBox();
		//Parent pippo = FXMLLoader.load(getClass().getResource("resources/navbarHome.fxml"));
		root = FXMLLoader.<VBox>load(getClass().getResource("../resources/navbarHome.fxml"));
		//root.getChildren().add();
		return root;
	}
	

}
