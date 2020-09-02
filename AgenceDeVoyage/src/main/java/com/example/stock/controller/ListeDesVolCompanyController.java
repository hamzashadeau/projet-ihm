package com.example.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Employe;
import com.example.stock.Bean.Hotel;
import com.example.stock.Bean.User;
import com.example.stock.Bean.VolCompany;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Service.Facade.HotelService;
import com.example.stock.Service.Facade.VolCompanyService;
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
@FxmlView("listDesVolCompany.fxml")
public class ListeDesVolCompanyController {
	private final FxWeaver fxWeaver;
	//private Stage stage;
	@FXML
	private AnchorPane volList;
	@FXML
	private TableView<VolCompany> voltable = new TableView<VolCompany>();

	@FXML
	private TableColumn<VolCompany, String> colVolNom;

	@FXML
	private TableColumn<VolCompany, String> colVolDescription;

	@FXML
	private TableColumn<VolCompany, Long> colVolId;


	@FXML
	private Button AllVols;
	
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
	private VolCompanyService volCompanyService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private ClientVolService clientVolService;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	@FXML
	private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView;

	private ObservableList<VolCompany> volListt = FXCollections.observableArrayList();
List<VolCompany> voll = new ArrayList<VolCompany>();
	@FXML
	public void initialize() {
		
	//Stage stage = new Stage();
		//stage.setScene(new Scene(employeList));
		//stage.show();
		chercher.setOnAction(event ->{
			System.out.println(motif.getText());
			if(nom.isSelected()) {
				voll =  volCompanyService.findByNom(motif.getText());

			}
			volListt.clear();
			voll.forEach(emp ->{
				volListt.add(emp);
			});
			voltable.setItems(volListt);
			
		});
		AllVols.setOnAction(actionevent ->{
			setColumnProperties();
			loadUserDetails();
			show();
		});
delete.setOnAction(
		actionevent ->{
volCompanyService.deleteById(getselectedItem().getId());
	loadUserDetails();
});
deleteAll.setOnAction(
		actionevent ->{
			List<VolCompany> vols = volCompanyService.findAll();
			for (VolCompany vol : vols) {
	volCompanyService.deleteById(vol.getId());
}
loadUserDetails();
});

	}
VolCompany  getselectedItem() {
	return  voltable.getSelectionModel().getSelectedItem();
}
	public void show() {
	//	stage.show();
	}

	public ListeDesVolCompanyController(FxWeaver fxWeaver,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	private void loadUserDetails(){
		volListt.clear();
		List<VolCompany> vols = volCompanyService.findAll();
		for (VolCompany vol : vols) {
			volListt.add(vol);}	
	voltable.setItems(volListt);
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
		colVolNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colVolDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
	}

}