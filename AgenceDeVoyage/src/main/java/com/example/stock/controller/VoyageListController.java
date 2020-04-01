package com.example.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VoyageService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("VoyageList.fxml")
public class VoyageListController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private AnchorPane voyageliste;
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
	
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	 @FXML
	 private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView;

	private ObservableList<Voyage> voyageList = FXCollections.observableArrayList();

	@Autowired
	private VoyageService voyageService;

	@FXML
	public void initialize() {
	}

	public void show() {
	}


Voyage  getselectedItem() {
	return  voyagetable.getSelectionModel().getSelectedItem();
}
	public VoyageListController(FxWeaver fxWeaver,
			FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}

	public void afficherListe(String destination) {
		setColumnProperties();
		List<Voyage> liste = voyageService.findByDestination(destination);
		for (Voyage voyage : liste) {
			System.out.println(voyage);
			voyageList.add(voyage);
		}
		voyagetable.setItems(voyageList);
		show();
	}

	private void setColumnProperties() {
		colVoyageId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("deteDebut"));
		coldetefin.setCellValueFactory(new PropertyValueFactory<>("detefin"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
	}

}