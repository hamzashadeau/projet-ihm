package com.example.stock.controller;

import org.springframework.stereotype.Component;

import com.example.stock.Tools.Tools;
import com.example.stock.config.PrimaryStageInitializer;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("PageChoix.fxml")
public class PageChoixConntroller {

	private final FxWeaver fxWeaver;
	
	@FXML
	private AnchorPane pageChoix;

	@FXML
	private BorderPane border;
	
	@FXML
	private  JFXButton compteUtlisateur;

	@FXML
	private  JFXButton cherche;

	@FXML
	private Label label;
	
	@FXML
	private Label name;
	
	@FXML
	private  Button logup;
	private final FxControllerAndView<registerLoginController, AnchorPane> anotherControllerAndView1;
	private final FxControllerAndView<loginController, AnchorPane> anotherControllerAndView2;
	private final FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView3;

	
	@FXML
	public void initialize() {
		name.setText(loginController.user.getFirstName()+ " "+ loginController.user.getLasName());
		cherche.setOnAction(avent ->{
			Scene scene = new Scene(fxWeaver.loadView(AcceuilPrincipal.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
		//	anotherControllerAndView1.getController()
		});
		compteUtlisateur.setOnAction(event ->{
			Scene scene = new Scene(fxWeaver.loadView(CompteSpaceController.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
		//	anotherControllerAndView1.getController()
		});
		//stage.setScene(new Scene(acceuil));
		//stage.show();
	/*	logup.setOnAction(
				actionevent -> {
			border.setCenter(Tools.loadPage(fxWeaver, registerLoginController.class, AnchorPane.class));
			logup.setStyle("-fx-background-color:#C13A0A");
			login.setStyle("-fx-background-color: #030540");
			espace.setStyle("-fx-background-color: #030540");
		});*/
		/*login.setOnAction(
				actionevent -> {
					 Scene scene = new Scene(fxWeaver.loadView(loginController.class));
				       PrimaryStageInitializer.stage.setScene(scene);
				       PrimaryStageInitializer.stage.show();
				//	stageManager.changeScene(label,acceuil);
			//border.setCenter(Tools.loadPage(fxWeaver, loginController.class, AnchorPane.class));
			//logup.setStyle("-fx-background-color: #030540");
			//login.setStyle("-fx-background-color:#C13A0A");
			//espace.setStyle("-fx-background-color: #030540");
				});
	/*	espace.setOnAction(
				actionevent -> {
			border.setCenter(Tools.loadPage(fxWeaver, AcceuilPrincipal.class, AnchorPane.class));
			logup.setStyle("-fx-background-color: #030540");
			espace.setStyle("-fx-background-color:#C13A0A");
			login.setStyle("-fx-background-color: #030540");
				});*/
	}
	


	public PageChoixConntroller(FxWeaver fxWeaver,
			FxControllerAndView<registerLoginController, AnchorPane> anotherControllerAndView1,
			FxControllerAndView<loginController, AnchorPane> anotherControllerAndView2,
			FxControllerAndView<AcceuilPrincipal, AnchorPane> anotherControllerAndView3) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView1 = anotherControllerAndView1;
		this.anotherControllerAndView2 = anotherControllerAndView2;
		this.anotherControllerAndView3 = anotherControllerAndView3;
	}
	


		//border.setLeft(null);
		//border.setRight(null);
		//border.setBottom(null);
		//border.setTop(null);
//loadVoyageCherche();
//loadlogup();
//loadlogup();
		}			

//anotherControllerAndView.getController().afficherlesvoyage(destination.getText());

