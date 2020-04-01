package com.example.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Vol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VolService;
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
@FxmlView("VolList.fxml")
public class volListController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private AnchorPane volliste;
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
	private Button choisir;
	
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	 @FXML
	 private TableColumn<Voyage, Double> colprix;
	private final FxControllerAndView<VolInfoController, AnchorPane> anotherControllerAndView;

	private ObservableList<Vol> volList = FXCollections.observableArrayList();

	@Autowired
	private VolService volService;

	@FXML
	public void initialize() {
	//	stage = new Stage();
		//stage.setScene(new Scene(volliste));
	}

	public void show() {
	//	stage.show();
	}



	public volListController(FxWeaver fxWeaver,
			FxControllerAndView<VolInfoController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	Vol  getselectedItem() {
		return  volTable.getSelectionModel().getSelectedItem();
	}
	public void afficherListe(String destination) {
		setColumnProperties();
		List<Vol> liste = volService.findByDestination(destination);
		for (Vol vol : liste) {
			System.out.println(vol);
			volList.add(vol);
		}
		volTable.setItems(volList);
		show();
	}

	private void setColumnProperties() {
		colVolId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
		coldeteDeretour.setCellValueFactory(new PropertyValueFactory<>("dateDeRetour"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
	}

}