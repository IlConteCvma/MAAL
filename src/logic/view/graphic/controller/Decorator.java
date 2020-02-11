package logic.view.graphic.controller;

import javafx.scene.layout.AnchorPane;
import logic.view.ViewComponent;

public abstract class Decorator extends ViewComponent {

	private ViewComponent anchorPaneComponent;
	
	public Decorator(ViewComponent anchorPaneComponent){
		this.anchorPaneComponent = anchorPaneComponent;
	}
	
	@Override
	public AnchorPane draw() {
		AnchorPane resultsFromRedirection = this.anchorPaneComponent.draw(); 
		return resultsFromRedirection;
	}

}