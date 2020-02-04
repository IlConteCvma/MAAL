package logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.view.LoginPage;


public class MainClass extends Application{
	
	private static Stage stageRoot;
	private static VBox root;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stageRoot = stage;
		root = new LoginPage();
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
