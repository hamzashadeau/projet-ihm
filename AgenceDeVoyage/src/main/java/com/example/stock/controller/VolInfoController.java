package com.example.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Vol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VolService;
import com.example.stock.Service.Facade.VoyageService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("Volinfo.fxml")
public class VolInfoController {
	private final FxControllerAndView<CreeUnVolController, AnchorPane> anotherControllerAndView;
	private Stage stage;
	private final FxWeaver fxWeaver;
	@Autowired
	private VolService volService;
	@FXML
	private AnchorPane volinfo;
	@FXML
	private Label destination;
	@FXML
	private Label dateRetour;
	@FXML
	private Label dateDeVol;
	@FXML
	private Label idDeVol;
	@FXML
	private Label prix;
	@FXML
	private Label descriptionVolCompany;
	@FXML
	private ComboBox<String> alleretretour;
	@FXML
	private Button confirmer;
	private ObservableList<String> Typesdevol = FXCollections.observableArrayList("allée", "allée et retour");
	@FXML
	public void initialize() {
		//stage = new Stage();
		//stage.setScene(new Scene(volinfo));
		alleretretour.setItems(Typesdevol);
	}

	public void show() {
		//stage.show();
	}

	public String getType() {
		return alleretretour.getSelectionModel().getSelectedItem();
	}

	public void afficherInfo(Vol vol) {
		this.descriptionVolCompany.setText(vol.getVolCompany().getNom());
		//idDeVol.setText(String.valueOf(vol.getId()));
		// Vol vol = volService.findByDestination(destination);
		this.destination.setText(vol.getDestination());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String dateString = dateFormat.format(vol.getDateDebut());
		this.dateDeVol.setText(dateString);
		String dateString1 = dateFormat.format(vol.getDateDeRetour());
		this.dateRetour.setText(dateString1);
		String Prix = Double.toString(vol.getPrix());
		this.prix.setText(Prix);
		alleretretour.setOnAction(actionevent -> {
			if (getType() == "allée et retour") {
				String Prixmod = Double.toString(vol.getPrix() * 2);
				this.prix.setText(Prixmod);
				
			} else {
				this.prix.setText(Prix);
			}
		});
		;
		show();
	}

	public VolInfoController(FxControllerAndView<CreeUnVolController, AnchorPane> anotherControllerAndView,
			FxWeaver fxWeaver) {
		super();
		this.anotherControllerAndView = anotherControllerAndView;
		this.fxWeaver = fxWeaver;
	}

	public String getPrix() {
		return prix.getText() ;
	}
	/*
	 * public void afficherVoyageInfo(String destination) { List<Voyage> voyages =
	 * voyageService.findByDestination(destination); for (Voyage voyage : voyages) {
	 * this.destination.setText(destination); SimpleDateFormat formate = new
	 * SimpleDateFormat("dd/mm/yyyy"); String date =
	 * formate.format(voyage.getDeteDebut()); this.dateDeDebut.setText(date); String
	 * nbrdejour =new Long(DateUtil.calculerLeNombreDeJours(voyage.getDeteDebut(),
	 * voyage.getDetefin())).toString() ; this.nombreDeJours.setText(nbrdejour);
	 * this.agenceDeVols.setText(voyage.getVolCompany().getNom());
	 * this.typeDeVoyage.setText(voyage.getTypeVoyage());
	 * this.description.setText(voyage.getDescription()); }
	 */

}
