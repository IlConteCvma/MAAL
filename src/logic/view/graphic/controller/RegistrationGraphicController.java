package logic.view.graphic.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.bean.UserBean;
import logic.controller.RegistrationController;
import logic.model.TypeVehicle;
import logic.view.AlertControl;
import logic.view.NamePage;

public class RegistrationGraphicController extends GraphicController implements Initializable {

	private static final int ROWPERSONALDATA = 2;
	private static final int COLPERSONALDATA = 2;
	private static final String[] PERSONALDATA = { "name", "surname", "street", "city" };
	private static final String[] CREDENTIAL = { "username", "password" };
	private static final int NUMCREDENTIAL = 2;

	@FXML
	private GridPane personalDataGridPane;
	@FXML
	private GridPane credentialDataGridPane;
	@FXML
	private ChoiceBox<String> choiceBoxProfession;
	@FXML
	private ChoiceBox<TypeVehicle> choiceBoxVehicle;
	@FXML
	private ImageView refresh;

	TextField[] textFieldPersonalData = new TextField[4];
	TextField[] textFieldCredential = new TextField[2];
	TextField streetNumberField;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Set the gridpane of personal data
		personalDataGridPane.setHgap(10);
		personalDataGridPane.setVgap(10);
		for (int i = 0; i < ROWPERSONALDATA; i++) {
			for (int j = 0; j < COLPERSONALDATA; j++) {
				Label l = new Label("Insert " + PERSONALDATA[ROWPERSONALDATA * i + j]);
				VBox verticalBox;
				textFieldPersonalData[ROWPERSONALDATA * i + j] = new TextField();
				textFieldPersonalData[ROWPERSONALDATA * i + j].setPromptText(PERSONALDATA[ROWPERSONALDATA * i + j]);
				if (i == 1 && j == 0) {
					streetNumberField = new TextField();
					streetNumberField.setMaxWidth(60);
					streetNumberField.setPromptText("n°");
					HBox horizzontalBox = new HBox(textFieldPersonalData[ROWPERSONALDATA * i + j],
							streetNumberField);
					verticalBox = new VBox(l, horizzontalBox);

				} else {
					verticalBox = new VBox(l, textFieldPersonalData[ROWPERSONALDATA * i + j]);
				}
				personalDataGridPane.add(verticalBox, j, i);
			}
		}

		credentialDataGridPane.setHgap(10);
		credentialDataGridPane.setVgap(10);

		// Set the gridpane of personal data
		for (int i = 0; i < NUMCREDENTIAL; i++) {
			Label l = new Label("Insert " + CREDENTIAL[i]);
			textFieldCredential[i] = new TextField();
			textFieldCredential[i].setPromptText(CREDENTIAL[i]);
			VBox verticalBox = new VBox(l, textFieldCredential[i]);
			credentialDataGridPane.add(verticalBox, i, 0);

		}

		// Set choiche box of profession
		choiceBoxProfession.getItems().addAll("Professor", "Student");
		choiceBoxProfession.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue,
						String newValue) -> changeProfession(newValue));

		// Set choiche box
		choiceBoxVehicle.getItems().addAll(TypeVehicle.BUS, TypeVehicle.CAR, TypeVehicle.SCOOTER);
		choiceBoxVehicle.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends TypeVehicle> observable, TypeVehicle oldValue,
						TypeVehicle newValue) -> changeVehicle(newValue));
	}

	@FXML
	public void signIn() throws IOException {
		goToPage(NamePage.LOGIN);
	}

	@FXML
	public void signUp() {

		// check data inserted
		if (checkData()) {
			if (AlertControl.confirmation()) {
				UserBean newUser = new UserBean();
				populeBean(newUser);
				new RegistrationController(newUser);
			}
		} else {

		}
	}

	public void changeProfession(String param) {
		/*if (param.equals("Student")) {
			AlertControl.infoBox("Hi student", "Welcome Student");
		} else {
			AlertControl.infoBox("Hi professor", "Welcome Professor");
		}*/
	}
	
	public void changeVehicle(TypeVehicle param) {
		switch(param) {
		case BUS:
			System.out.println("ciao");
			break;
		case CAR:
			break;
		case SCOOTER:
			break;
		default:
			break;
		}
	}

	private boolean checkData() {

		// check personal data
		for (int i = 0; i < textFieldPersonalData.length - 1; i++) {
			if (textFieldPersonalData[i].getText().isEmpty()) {
				AlertControl.infoBox("Check personal data", "Error");
				return false;
			}
		}

		// check credential
		for (int i = 0; i < textFieldCredential.length; i++) {
			if (textFieldCredential[i].getText().isEmpty()) {
				AlertControl.infoBox("Check credential", "Error");
				return false;
			}
		}

		return true;
	}

	private void populeBean(UserBean newUser) {
		newUser.setName(textFieldPersonalData[0].getText());
		newUser.setSurname(textFieldPersonalData[1].getText());
		newUser.setUsername(textFieldCredential[0].getText());
		newUser.setPassword(textFieldCredential[1].getText());
		newUser.setAddress(textFieldPersonalData[2].getText());
		newUser.setCity(textFieldPersonalData[2].getText());
		newUser.setNumberOfStreet(streetNumberField.getText());
		newUser.setVehicle(choiceBoxVehicle.getValue());
	}

}