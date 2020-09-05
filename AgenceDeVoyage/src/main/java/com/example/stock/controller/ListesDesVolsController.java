package com.example.stock.controller;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Vol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VolService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
@FxmlView("ListesDesVols.fxml")
public class ListesDesVolsController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private AnchorPane listeDesVols;
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
	private TableColumn<Vol, Double> colprix;
	@FXML
	private Button choisir;
	
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	private final FxControllerAndView<VolInfoController, AnchorPane> anotherControllerAndView;

	private ObservableList<Vol> volList = FXCollections.observableArrayList();

	@Autowired
	private VolService volService;
@FXML
private Button chercher;
@FXML
private DatePicker dateDeDebut;
@FXML
private JFXCheckBox prix;
@FXML
private JFXCheckBox destination;
@FXML
private JFXCheckBox date;
@FXML
private JFXTextField motif;
private List<Vol> vols = new ArrayList<Vol>();
	@FXML
	public void initialize() {
		chercher.setOnAction(event ->{
			if(!prix.isSelected()) {
				vols = volService.findByPrix(Double.parseDouble(motif.getText()));
			}else if(!destination.isSelected()) {
				vols =volService.findByDestination(motif.getText());
				}else if(!date.isSelected()) {
					vols =volService.findByDateDebut(dateDeDebut.getValue());
				}
			volList.clear();
			vols.forEach(emp ->{
				volList.add(emp);
			});
			volTable.setItems(volList);
		});
		setColumnProperties();
		List<Vol> liste = volService.findAll();
		for (Vol vol : liste) {
			System.out.println(vol);
			volList.add(vol);
		}
		volTable.setItems(volList);
		show();
	//	stage = new Stage();
		//stage.setScene(new Scene(volliste));
	}

	public void show() {
	//	stage.show();
	}



	public ListesDesVolsController(FxWeaver fxWeaver,
			FxControllerAndView<VolInfoController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}
	Vol  getselectedItem() {
		return  volTable.getSelectionModel().getSelectedItem();
	}
	public void afficherListe() {
	}

	private void setColumnProperties() {
		colVolId.setCellValueFactory(new PropertyValueFactory<>("id"));
		coldeteDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
		coldeteDeretour.setCellValueFactory(new PropertyValueFactory<>("dateDeRetour"));
		coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
	}

}