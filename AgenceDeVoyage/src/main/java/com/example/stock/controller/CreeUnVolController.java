package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Vol;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Service.Facade.VolService;
import com.example.stock.Tools.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("CreeUnVol.fxml")
public class CreeUnVolController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private TextField nomClient;
	@FXML
	private TextField prenomClient;
	@FXML
	private TextField email;
	@FXML
	private TextField age;
	@FXML
	private Label idDeVoyage;
	@FXML
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private ComboBox<Integer> ages;
	@FXML
	private Button save;
	@FXML
	private AnchorPane creeUnvol;
	@Autowired
	private VolService volService;
	@Autowired
	private UserService userService;
	private ObservableList<Integer> Typess = FXCollections.observableArrayList();
	@Autowired
	private ClientVolService clientVolService;
	private ClientVol clientVol = new ClientVol();
	private User user = new User();
private Vol vol1 = new Vol();
private Double prixmod; 
	@FXML
	public void initialize() {
	//	stage = new Stage();
		//stage.setScene(new Scene(creeUnvol));
		for (int i = 0; i < 100; i++) {
			Typess.add(i);
		}
		ages.setItems(Typess);
	}

	public void show() {
	//	stage.show();
	}

	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}
	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public CreeUnVolController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
	public void sauvgarderClient(Vol vol,String prix) {
User user = loginController.user;
if(user!=null) {
	nomClient.setText(user.getLasName());
	prenomClient.setText(user.getFirstName());
	email.setText(user.getLogin());
	ages.setValue(user.getAge());
	if(user.getGender().equals("Male")) {
		rbMale.setSelected(true);
	}else {
		rbFemale.setSelected(true);
	}
}
vol1 = vol;
idDeVoyage.setText(String.valueOf(vol.getId()));
 prixmod = new Double(prix);
//		show();
	}
	public void save() {
		clientVol.setId(Tools.generateRandomIntIntRange(1, 200));
			clientVol.setNom(nomClient.getText());
			clientVol.setPrenom(prenomClient.getText());
			// int Age = Integer.parseInt(age.getText());
			clientVol.setAge(getType());
			clientVol.setGender(getGender());
			clientVol.setEmail(email.getText());
			clientVol.setVol(vol1);
			clientVol.getVol().setPrix(prixmod);
			clientVolService.save(clientVol);
			user.getVols().add(vol1);
	}
}