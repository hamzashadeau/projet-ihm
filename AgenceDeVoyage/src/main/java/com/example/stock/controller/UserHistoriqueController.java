package com.example.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("UserHistorique.fxml")
public class UserHistoriqueController {
	private final FxWeaver fxWeaver;
	//private Stage stage;
	@FXML
	private AnchorPane userList;
	@FXML
	private TableView<Voyage> usertable = new TableView<Voyage>();

	@FXML
	private TableColumn<Voyage, Long> colVoyageId;

	@FXML
	private TableColumn<Voyage, Date> coldeteDebut;

	@FXML
	private TableColumn<Voyage, Date> coldetefin;

	@FXML
	private TableColumn<Voyage, String> coldestination;
	@FXML
	private TableColumn<Voyage, String> coltype;
	
	@FXML
	private TableColumn<Voyage, Long> colVoyageetat;

	@FXML
	private Button Allvoyage;
	
	@FXML
	private Button AllVol;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button deleteAll;
	
	@FXML
	private Button logout;
	
	@FXML
	private Label bonjour;

	@Autowired
	private ClientService clientService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private ClientVolService clientVolService;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	@FXML
	private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView;

	private ObservableList<Voyage> voyageList = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
	//	stage = new Stage();
		//stage.setScene(new Scene(userList));
		Allvoyage.setOnAction(actionevent ->{
			setColumnProperties();
			loadUserDetails();
			show();
		});
delete.setOnAction(
		actionevent ->{
			List<VoyageClient> voyageClients = voyageClientService.findAll();
for (VoyageClient voyageClient : voyageClients) {
	if(voyageClient.getVoyage().getId()== getselectedItem().getId()) {
		voyageClientService.deleteById(voyageClient.getId());
	}
	loadUserDetails();
}
});
deleteAll.setOnAction(
		actionevent ->{
			List<VoyageClient> voyageClients = voyageClientService.findAll();
for (VoyageClient voyageClient : voyageClients) {
	voyageClientService.deleteById(voyageClient.getId());
}
loadUserDetails();
});

	}

	public void show() {
	//	stage.show();
	}

	public UserHistoriqueController(FxWeaver fxWeaver,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	Voyage  getselectedItem() {
		return  usertable.getSelectionModel().getSelectedItem();
	}
	private void loadUserDetails(){
		voyageList.clear();
		List<VoyageClient> voyageClients = voyageClientService.findAll();
		for (VoyageClient voyageClient : voyageClients) {
			if (voyageClient.getEmail().equals(loginController.user.getLogin()))
				voyageList.add(voyageClient.getVoyage());
		}
		usertable.setItems(voyageList);
	}
	public void afficherListe(User user) {
	//	bonjour.setText(user.getFirstName() +  user.getLasName());
	//	show();
	//	stage.setScene(new Scene(userList));
		//stage.show();
		//show();

	}

	
	private void setColumnProperties() {
		colVoyageId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("deteDebut"));
		coldetefin.setCellValueFactory(new PropertyValueFactory<>("detefin"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		colVoyageetat.setCellValueFactory(new PropertyValueFactory<>("etat"));

	}

}