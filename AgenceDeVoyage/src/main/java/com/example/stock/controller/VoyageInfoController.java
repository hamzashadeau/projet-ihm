package com.example.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VoyageService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("Voyageinfo.fxml")
public class VoyageInfoController {
	private final FxControllerAndView<CreeUnVoyageController, AnchorPane> anotherControllerAndView;
	private Stage stage;
	private final FxWeaver fxWeaver;
	@Autowired
	private VoyageService voyageService;
	@FXML
	private AnchorPane voyageinfo;
	@FXML
	private Label destination;
	@FXML
	private Label description;
	@FXML
	private Label dateDeDebut;
	@FXML
	private Label nombreDeJours;
	@FXML
	private Label agenceDeVols;
	@FXML
	private Label nomDeVoyage;
	@FXML
	private Button confirmer;

	@FXML
	public void initialize() {

	}

	public void show() {
//		stage.show();
	}

	public void afficherInfo(Voyage voyage) {
	//	Voyage voyage = voyageService.findByDestination(destination);
		this.description.setText(voyage.getDescription());
		this.destination.setText(voyage.getDestination());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String dateString = dateFormat.format(voyage.getDeteDebut());
		this.dateDeDebut.setText(dateString);
		String nbrdejour = new Long(DateUtil.calculerLeNombreDeJours(voyage.getDeteDebut(), voyage.getDetefin()))
				.toString();
		this.nombreDeJours.setText(nbrdejour);
		this.nomDeVoyage.setText(voyage.getNomVoyage());
		show();
	}

	public VoyageInfoController(FxControllerAndView<CreeUnVoyageController, AnchorPane> anotherControllerAndView,
			FxWeaver fxWeaver) {
		super();
		this.anotherControllerAndView = anotherControllerAndView;
		this.fxWeaver = fxWeaver;
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
