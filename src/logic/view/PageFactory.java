package logic.view;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import logic.view.graphicElements.GraphicElementInterface;

public class PageFactory {
	public  createPage(String type) throws Exception{
	
		switch(type) {
			case "homePage": return new HomePage();
			
			default: throw new Exception("Invalid type : " + type);
			
		}
		
		
		
		
		
	}
}
