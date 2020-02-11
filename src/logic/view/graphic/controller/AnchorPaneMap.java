package logic.view.graphic.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.view.ViewComponent;

public class AnchorPaneMap extends Decorator{

	public AnchorPaneMap(ViewComponent anchorPaneComponent) {
		super(anchorPaneComponent);
	}
	
	public AnchorPane manageMap(AnchorPane anchorPane) {
		return anchorPane;
	}
	
	@Override
	public AnchorPane draw() {
		AnchorPane preliminaryResults = super.draw();
		preliminaryResults = this.manageMap(preliminaryResults);
		return preliminaryResults;
	}

}
