package com.example.stock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Employe;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
@FxmlView("listDesEmployes.fxml")
public class ListeDesEmployesController {
	private final FxWeaver fxWeaver;
	//private Stage stage;
	@FXML
	private AnchorPane employeList;
	@FXML
	private TableView<Employe> employetable = new TableView<Employe>();

	@FXML
	private TableColumn<Employe, String> colemployeNom;

	@FXML
	private TableColumn<Employe, String> colemployePrenom;

	@FXML
	private TableColumn<Employe, String> colemployeEmail;

	@FXML
	private TableColumn<Employe, String> colemployeAddress;
	@FXML
	private TableColumn<Employe, String> colemployeCin;
	
	@FXML
	private TableColumn<Employe, String> colemployeTelephone;

	@FXML
	private Button AllEmploye;
	
	@FXML
	private Button AllVol;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button deleteAll;
	
	@FXML
	private Button logout;
	@FXML
	private Button chercher;
	
	@FXML
	private Label bonjour;
	@FXML
	private JFXTextField motif;
	
	@FXML
	private JFXCheckBox codeEmp;
	@FXML
	private JFXCheckBox nom;
	@FXML
	private JFXCheckBox prenom;
	@FXML
	private JFXCheckBox cin;

	@Autowired
	private EmployeService employeService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private ClientVolService clientVolService;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	@FXML
	private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView;

	private ObservableList<Employe> employeListt = FXCollections.observableArrayList();
List<Employe> employess = new ArrayList<Employe>();
	@FXML
	public void initialize() {
		
	//Stage stage = new Stage();
		//stage.setScene(new Scene(employeList));
		//stage.show();
		chercher.setOnAction(event ->{
			System.out.println(motif.getText());
			if(nom.isSelected()) {
				employess =  employeService.findByNom(motif.getText());

			}else if(prenom.isSelected()) {
				employess = employeService.findByPrenom(motif.getText());
				
			}else if(cin.isSelected()) {
				employess= employeService.findByCin(motif.getText());
			}
			employeListt.clear();
			employess.forEach(emp ->{
				employeListt.add(emp);
			});
			employetable.setItems(employeListt);
			
		});
		AllEmploye.setOnAction(actionevent ->{
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

	public ListeDesEmployesController(FxWeaver fxWeaver,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	Employe  getselectedItem() {
		return  employetable.getSelectionModel().getSelectedItem();
	}
	private void loadUserDetails(){
		employeListt.clear();
		List<Employe> employes = employeService.findAll();
		for (Employe employe : employes) {
				employeListt.add(employe);
		}
		employetable.setItems(employeListt);
	}
	public void afficherListe(User user) {
	//	bonjour.setText(user.getFirstName() +  user.getLasName());
	//	show();
	//	stage.setScene(new Scene(userList));
		//stage.show();
		//show();

	}

	
	private void setColumnProperties() {
		colemployePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		colemployeNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colemployeCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
		colemployeTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		colemployeAddress.setCellValueFactory(new PropertyValueFactory<>("adress"));
		colemployeEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

	}

}