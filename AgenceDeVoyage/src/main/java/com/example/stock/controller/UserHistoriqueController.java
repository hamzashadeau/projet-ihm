package com.example.stock.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.VoyageClientService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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
	private TableView<VoyageClient> usertable = new TableView<VoyageClient>();

	@FXML
	private TableColumn<VoyageClient, Long> colVoyageId;

	@FXML
	private TableColumn<VoyageClient, Date> coldate;
	@FXML
	private TableColumn<VoyageClient, String> colCodeClient;

	@FXML
	private TableColumn<VoyageClient, String> colVoyage;
	

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

	private ObservableList<VoyageClient> voyageList = FXCollections.observableArrayList();
	@FXML
	private Button chercher;
	@FXML
	private DatePicker dateDebut;
	@FXML
	private CheckBox voyage;
	@FXML
	private CheckBox codeClient;
	@FXML
	private CheckBox date;
	@FXML
	private TextField motif;
	
	//@Autowired
//	private List<VoyageClient> vols = new ArrayList<VoyageClient>();
	private List<VoyageClient> voyages = new ArrayList<VoyageClient>();
	
	@FXML
	public void initialize() {
		chercher.setOnAction(event ->{
			if(codeClient.isSelected()) {
			voyages = voyageClientService.findByCodeClient(motif.getText());
			}else if(voyage.isSelected()) {
				voyages =voyageClientService.findByNomVoyage(motif.getText());
				}else if(date.isSelected()) {
					
					//ZoneId defaultZoneId = ZoneId.systemDefault();
					//Date date = convertToDateViaInstant(dateDebut.getValue());
				    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    //String strDate= formatter.format(date);  
				  
				voyages =voyageClientService.findByDate(dateDebut.getValue());
				}
			voyageList.clear();
			System.out.println(voyages);
			voyages.forEach(emp ->{
				System.out.println(emp);
			voyageList.add(emp);
			});
			usertable.setItems(voyageList);
		});
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
	VoyageClient  getselectedItem() {
		return  usertable.getSelectionModel().getSelectedItem();
	}
	private void loadUserDetails(){
		voyageList.clear();
		List<VoyageClient> voyageClients = voyageClientService.findAll();
		for (VoyageClient voyageClient : voyageClients) {
				voyageList.add(voyageClient);
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
		colCodeClient.setCellValueFactory(new PropertyValueFactory<>("codeClient"));
		colVoyage.setCellValueFactory(new PropertyValueFactory<>("nomVoyage"));
		coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
	//	colVoyageetat.setCellValueFactory(new PropertyValueFactory<>("nomVoyage"));

	}

}