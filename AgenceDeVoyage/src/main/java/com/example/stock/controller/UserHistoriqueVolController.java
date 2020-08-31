package com.example.stock.controller;

import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	private TableView<ClientVol> volTable = new TableView<ClientVol>();

	@FXML
	private TableColumn<ClientVol, Long> colVolId;

	@FXML
	private TableColumn<ClientVol, Date> coldate;

	@FXML
	private TableColumn<ClientVol, String> colCodeClient;
	@FXML
	private TableColumn<ClientVol, Long> colVol;


	@FXML
	private Button chercher;
	@FXML
	private DatePicker dateDebut;
	@FXML
	private CheckBox vol;
	@FXML
	private CheckBox codeClient;
	@FXML
	private CheckBox date;
	@FXML
	private TextField motif;

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

	private ObservableList<ClientVol> volList = FXCollections.observableArrayList();
List<ClientVol> vols = new ArrayList<ClientVol>();
	@FXML
	public void initialize() {
		chercher.setOnAction(event ->{
			if(codeClient.isSelected()) {
			vols = volClientService.findByCodeClient(motif.getText());
			}else if(vol.isSelected()) {
				vols =volClientService.findByVolId(Long.parseLong(motif.getText()));
				}else if(date.isSelected()) {
					
					//ZoneId defaultZoneId = ZoneId.systemDefault();
					//Date date = convertToDateViaInstant(dateDebut.getValue());
				    //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    //String strDate= formatter.format(date);  
				  
				vols =volClientService.findByDate(dateDebut.getValue());
				}
			volList.clear();
			vols.forEach(emp ->{
				System.out.println(emp);
			volList.add(emp);
			});
			volTable.setItems(volList);
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
	ClientVol  getselectedItem() {
		return  volTable.getSelectionModel().getSelectedItem();
	}
	private void loadUserDetails(){
		volList.clear();
		List<ClientVol> volClients = volClientService.findAll();
		for (ClientVol volClient : volClients) {
				volList.add(volClient);
			}
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
		colCodeClient.setCellValueFactory(new PropertyValueFactory<>("codeClient"));
		coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
		colVol.setCellValueFactory(new PropertyValueFactory<>("iDVol"));
	
	}


}