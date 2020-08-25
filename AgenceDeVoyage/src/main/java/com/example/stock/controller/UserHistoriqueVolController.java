package com.example.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Vol;
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
@FxmlView("UserHistoriqueVol.fxml")
public class UserHistoriqueVolController {
	private final FxWeaver fxWeaver;
	//private Stage stage;
	@FXML
	private AnchorPane uservolList;
	@FXML
	private TableView<Vol> volTable = new TableView<Vol>();

	@FXML
	private TableColumn<Vol, Long> colVolId;

	@FXML
	private TableColumn<Vol, Date> coldeteDebut;

	@FXML
	private TableColumn<Vol, Date> coldeteDeretour;

	@FXML
	private TableColumn<Vol, String> coldestination;
	@FXML
	private TableColumn<Voyage, Double> colprix;

	@FXML
	private TableColumn<Vol, Long> colVoletat;
	

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
	private ClientVolService volClientService;
	@Autowired
	private ClientVolService clientVolService;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView;

	private ObservableList<Vol> volList = FXCollections.observableArrayList();

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
			List<ClientVol> volClients = volClientService.findAll();
for (ClientVol volClient : volClients) {
	if(volClient.getVol().getId()== getselectedItem().getId()) {
		volClientService.deleteById(volClient.getId());
	}
	loadUserDetails();
}
});
deleteAll.setOnAction(
		actionevent ->{
			List<ClientVol> volClients = volClientService.findAll();
			for (ClientVol volClient : volClients) {
				volClientService.deleteById(volClient.getId());
}
loadUserDetails();
});

	}

	public void show() {
	//	stage.show();
	}

	public UserHistoriqueVolController(FxWeaver fxWeaver,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	Vol  getselectedItem() {
		return  volTable.getSelectionModel().getSelectedItem();
	}
	private void loadUserDetails(){
		volList.clear();
		List<ClientVol> volClients = volClientService.findAll();
		for (ClientVol volClient : volClients) {
			if (volClient.getEmail().equals(loginController.user.getLogin())) {
				volList.add(volClient.getVol());
		System.out.println(volClient.getVol());
			}}
		volTable.setItems(volList);
	}
	public void afficherListe(User user) {
	//	bonjour.setText(user.getFirstName() +  user.getLasName());
	//	show();
	//	stage.setScene(new Scene(userList));
		//stage.show();
		//show();

	}

	
	private void setColumnProperties() {
		colVolId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
		coldeteDeretour.setCellValueFactory(new PropertyValueFactory<>("dateDeRetour"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		colVoletat.setCellValueFactory(new PropertyValueFactory<>("etat"));
		
	}


}