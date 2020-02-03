package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainClass extends Application{
	
	private static Stage stageRoot;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stageRoot = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("view/resources/LoginView.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MAAL Assistant");
		stage.setResizable(false);
		stage.show();
	}
	
	public static Stage getStage() {
        return stageRoot;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
