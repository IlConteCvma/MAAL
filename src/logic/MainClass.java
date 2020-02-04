package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.view.graphicElements.Navbar;


public class MainClass extends Application{
	
	private static Stage stageRoot;
	private static VBox root;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stageRoot = stage;
		
		//Parent root = FXMLLoader.load(getClass().getResource("view/resources/LoginView.fxml"));
		root = new VBox();
		
		Navbar nav = new Navbar();
		root.getChildren().add(nav.draw());
		
		Button ciao = new Button();
		root.getChildren().add(ciao);
		
		
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MAAL Assistant");
		stage.setResizable(false);
		stage.show();
	}
	
	public static Stage getStage() {
        return stageRoot;
    }
	
	public static VBox  getRoot() {
        return root;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
