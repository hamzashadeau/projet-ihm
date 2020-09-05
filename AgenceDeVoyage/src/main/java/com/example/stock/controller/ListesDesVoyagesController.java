package com.example.stock.controller;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VoyageService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ListesDesVoyageOrganise.fxml")
public class ListesDesVoyagesController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private AnchorPane ListeDesVoyage;
	@FXML
	private TableView<Voyage> voyagetable = new TableView<Voyage>();

	@FXML
	private TableColumn<Voyage, Long> colVoyageId;

	@FXML
	private TableColumn<Voyage, Date> coldeteDebut;

	@FXML
	private TableColumn<Voyage, Date> coldetefin;

	@FXML
	private TableColumn<Voyage, String> coldestination;
	@FXML
	private Button choisir;
	@FXML
	private Button chercher;
	@FXML
	private DatePicker dateDebut;
	@FXML
	private JFXCheckBox prix;
	@FXML
	private JFXCheckBox destination;
	@FXML
	private JFXCheckBox date;
	@FXML
	private JFXTextField motif;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	 @FXML
	 private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView;

	private ObservableList<Voyage> voyageList = FXCollections.observableArrayList();

	@Autowired
	private VoyageService voyageService;
List<Voyage> voyages = new ArrayList<Voyage>();
	@FXML
	public void initialize() {
		chercher.setOnAction(event ->{
			if(!prix.isSelected()) {
				voyages = voyageService.findByPrix(Double.parseDouble(motif.getText()));
			}else if(!destination.isSelected()) {
				voyages =voyageService.findByDestination(motif.getText());
				}else if(!date.isSelected()) {
					ZoneId defaultZoneId = ZoneId.systemDefault();

				voyages =voyageService.findByDateDebut(dateDebut.getValue());
				}
			voyageList.clear();
			voyages.forEach(emp ->{
				voyageList.add(emp);
			});
			voyagetable.setItems(voyageList);
		});
		setColumnProperties();
		List<Voyage> liste = voyageService.findAll();
		for (Voyage voyage : liste) {
			voyageList.add(voyage);
		}
		voyagetable.setItems(voyageList);
	}

	public void show() {
	}


Voyage  getselectedItem() {
	return  voyagetable.getSelectionModel().getSelectedItem();
}
	public ListesDesVoyagesController(FxWeaver fxWeaver,
			FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}

	public void afficherListe(String destination) {
	}

	private void setColumnProperties() {
		colVoyageId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("deteDebut"));
		coldetefin.setCellValueFactory(new PropertyValueFactory<>("detefin"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
	}

}