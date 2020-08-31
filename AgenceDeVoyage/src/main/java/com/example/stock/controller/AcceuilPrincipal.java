package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.config.PrimaryStageInitializer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("AcceuilPrincipal.fxml")
public class AcceuilPrincipal {
	private Stage stage;

	@FXML
	private AnchorPane acceuiprincipal;
	@FXML
	private Button chercherUnvoyage;
	@FXML
	private Button retour;
	@FXML
	private CheckBox voyageOrganise;
	@FXML
	private CheckBox vol;
	@FXML
	private TextField destination;
	private ObservableList<String> Types = FXCollections.observableArrayList("voyage Organisé", "vol");
	private final FxControllerAndView<VolSpaceController, AnchorPane> anotherControllerAndView2;
	private final FxWeaver fxWeaver;
	private final FxControllerAndView<VoyageSpaceController, AnchorPane> anotherControllerAndView;
@Autowired
private VoyageService voyageService;



	@FXML
	public void initialize() {
		//stage = new Stage();
		//stage.setScene(new Scene(acceuiprincipal));
		//typeDeVoyage.setItems(Types);
		retour.setOnAction(event ->{
			 Scene scene = new Scene(fxWeaver.loadView(PageChoixConntroller.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
	
		});
		try {
		chercherUnvoyage.setOnAction(actionEvent -> {
			if (voyageOrganise.isSelected()) {
				anotherControllerAndView.getController().reserver(destination.getText());
				 Scene scene = new Scene(fxWeaver.loadView(VoyageSpaceController.class));
			       PrimaryStageInitializer.stage.setScene(scene);
			       PrimaryStageInitializer.stage.show();
			}
			else if(vol.isSelected()) {
				anotherControllerAndView2.getController().reserver(destination.getText());
				 Scene scene = new Scene(fxWeaver.loadView(VolSpaceController.class));
			       PrimaryStageInitializer.stage.setScene(scene);
			       PrimaryStageInitializer.stage.show();
			}});				
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

	public AcceuilPrincipal(FxControllerAndView<VolSpaceController, AnchorPane> anotherControllerAndView2,
			FxWeaver fxWeaver, FxControllerAndView<VoyageSpaceController, AnchorPane> anotherControllerAndView) {
		super();
		this.anotherControllerAndView2 = anotherControllerAndView2;
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}


	

}