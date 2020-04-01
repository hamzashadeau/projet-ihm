package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Service.Facade.VoyageService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ChercherUnVol.fxml")
public class ChercherUnvol {
	private Stage stage;

	@FXML
	private AnchorPane cherchervol;
	@FXML
	private Button chercherUnvol;
	@FXML
	private TextField destination;
	private final FxWeaver fxWeaver;
	private final FxControllerAndView<volListController, AnchorPane> anotherControllerAndView;
@Autowired
private VoyageService voyageService;
	@FXML
	public void initialize() {
//		stage = new Stage();
	//	stage.setScene(new Scene(cherchervol));
		try {
			chercherUnvol.setOnAction(actionEvent -> {
				FxControllerAndView<volListController, AnchorPane> add_team = fxWeaver.load(volListController.class);
				add_team.getController().afficherListe(destination.getText());
				add_team.getView().get();
			});
		} catch (Exception e) {
			e.getStackTrace();
		}
		/*
		 * espaceClient.setOnAction(actionEvent -> {
		 * anotherControllerAndView2.getController().initialize(); });
		 */
	}

	public void show() {
		stage.show();
		
	}

	public ChercherUnvol(FxWeaver fxWeaver,
			FxControllerAndView<volListController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}

	
}