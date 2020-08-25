package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.Tools.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("CreeUnVoyage.fxml")
public class CreeUnVoyageController {
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
	private Button save;
	@FXML
	private ComboBox<Integer> ages;
	@FXML
	private AnchorPane creeUnvoyage;
	@Autowired
	private VoyageService voyageService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private UserService userService;
	private final FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView;
	private ObservableList<Integer> Types = FXCollections.observableArrayList();
	@Autowired
	private ClientService clientService;
	private Client client = new Client();
	private VoyageClient voyageClient = new VoyageClient();
	private Long IdC;
	private Voyage voyage1 = new Voyage();

	@FXML
	public void initialize() {
		for (int i = 0; i < 100; i++) {
			Types.add(i);
		}
		ages.setItems(Types);
	}

	public String getGender() {
		return rbMale.isSelected() ? "Male" : "Female";
	}

	public void show() {
//		stage.show();
	}

	public CreeUnVoyageController(FxWeaver fxWeaver,
			FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}

	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}

	public void sauvgarderClient(Voyage voyage) {
		User user = loginController.user;
		if (user != null) {
			nomClient.setText(user.getLasName());
			prenomClient.setText(user.getFirstName());
			email.setText(user.getLogin());
			ages.setValue(user.getAge());
			if (user.getGender().equals("Male")) {
				rbMale.setSelected(true);
			} else {
				rbFemale.setSelected(true);
			}
		}
//		User user=userService.findByLogin(email.getText());
		 voyage1 = voyage;
		idDeVoyage.setText(String.valueOf(voyage.getId()));

//		show();
	}

	public void save() {
		voyageClient.setId(Tools.generateRandomIntIntRange(1, 200));
		voyageClient.setNom(nomClient.getText());
		voyageClient.setPrenom(prenomClient.getText());
		voyageClient.setAge((int)getType());
		voyageClient.setGender(getGender());
		voyageClient.setEmail(email.getText());
		// client.getVoyages().add(voyage);
		// voyageClient.setClient(client);
		// Client client1 = clientService.findByEmail(client.getEmail());
	//	voyageClient.setClient(client);
		voyageClient.setVoyage(voyage1);
	//	voyageService.save(voyage);
		// clientService.save(client1);
		voyageClientService.save(voyageClient);
	}

}