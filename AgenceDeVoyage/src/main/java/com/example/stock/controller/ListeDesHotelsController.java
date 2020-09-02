package com.example.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Hotel;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.HotelService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("listDesHotels.fxml")
public class ListeDesHotelsController {
	private final FxWeaver fxWeaver;
	//private Stage stage;
	@FXML
	private AnchorPane hotelList;
	@FXML
	private TableView<Hotel> hoteltable = new TableView<Hotel>();

	@FXML
	private TableColumn<Hotel, String> colemployeNom;

	@FXML
	private TableColumn<Hotel, String> colemployeDescription;

	@FXML
	private TableColumn<Hotel, Long> colemployeId;


	@FXML
	private Button AllHotels;
	
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
	private HotelService hotelService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private ClientVolService clientVolService;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	@FXML
	private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView;

	private ObservableList<Hotel> hotelListt = FXCollections.observableArrayList();
List<Hotel> hotell = new ArrayList<Hotel>();
	@FXML
	public void initialize() {
		
	//Stage stage = new Stage();
		//stage.setScene(new Scene(employeList));
		//stage.show();
		chercher.setOnAction(event ->{
			System.out.println(motif.getText());
			if(nom.isSelected()) {
				hotell =  hotelService.findByNom(motif.getText());

			}
			hotelListt.clear();
			hotell.forEach(emp ->{
				hotelListt.add(emp);
			});
			hoteltable.setItems(hotelListt);
			
		});
		AllHotels.setOnAction(actionevent ->{
			setColumnProperties();
			loadUserDetails();
			show();
		});
delete.setOnAction(
		actionevent ->{
hotelService.deleteById(getselectedItem().getId());
	loadUserDetails();
});
deleteAll.setOnAction(
		actionevent ->{
			List<Hotel> hotels = hotelService.findAll();
			for (Hotel hotel : hotels) {
	hotelService.deleteById(hotel.getId());
}
loadUserDetails();
});

	}
Hotel  getselectedItem() {
	return  hoteltable.getSelectionModel().getSelectedItem();
}
	public void show() {
	//	stage.show();
	}

	public ListeDesHotelsController(FxWeaver fxWeaver,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	private void loadUserDetails(){
		hotelListt.clear();
		List<Hotel> hotels = hotelService.findAll();
		for (Hotel hotel : hotels) {
				hotelListt.add(hotel);
		}
		hoteltable.setItems(hotelListt);
	}
	public void afficherListe(User user) {
	//	bonjour.setText(user.getFirstName() +  user.getLasName());
	//	show();
	//	stage.setScene(new Scene(userList));
		//stage.show();
		//show();

	}

	
	private void setColumnProperties() {
		colemployeId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colemployeNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colemployeDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
	}

}