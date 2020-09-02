package com.example.stock.controller;

import org.springframework.stereotype.Component;

import com.example.stock.Tools.Tools;
import com.example.stock.config.PrimaryStageInitializer;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("comptespace.fxml")
public class CompteSpaceController {
	
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane CompteSpacee;

	@FXML
	private JFXButton edit;
	@FXML
	private JFXButton hotel;
	@FXML
	private JFXButton volCompany;
	@FXML
	private JFXButton vol;
	@FXML
	private JFXButton voyage;

	
	@FXML
	private JFXButton historique;
	@FXML
	private JFXButton statistique;
	@FXML
	private JFXButton accederAuCompte;
	
	@FXML
	private Label moi;
	@FXML
	private JFXButton logout;
	@FXML
	private JFXButton employe;


	@FXML
	private BorderPane borderpane;

	
//	private final FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView1;
	//private final FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView2;
//	private final FxControllerAndView<CreeUnVoyageController, AnchorPane> anotherControllerAndView3;
	//private final FxControllerAndView<UserHistoriqueController, AnchorPane> anotherControllerAndView4;


	
	public CompteSpaceController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
public void spacecompte (){
	//Stage stage1 = new Stage();
	//stage1.setScene(new Scene(CompteSpacee));
	//stage1.show();
}

	@FXML
	public void initialize() {
		moi.setText(loginController.user.getFirstName()+loginController.user.getLasName());
		borderpane.setLeft(null);
		borderpane.setRight(null);
		borderpane.setBottom(null);
		borderpane.setTop(null);
		edit.setOnAction(
				actionevent ->{
				borderpane.setCenter(Tools.loadPage(fxWeaver, editUserController.class, AnchorPane.class));
		});
		historique.setOnAction(
				actionevent ->{
			borderpane.setCenter(Tools.loadPage(fxWeaver, historiqueController.class, AnchorPane.class));

		});
		statistique.setOnAction(
				actionevent ->{
			borderpane.setCenter(Tools.loadPage(fxWeaver, AcceuilStatistiqueController.class, AnchorPane.class));
			//		anotherControllerAndView1.getController().acceuill();

		});
		logout.setOnAction(actionevent ->{
		//	stage1.close();
			loginController.user = null;
			Scene scene = new Scene(fxWeaver.loadView(loginController.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
		});
		employe.setOnAction(event -> {
			borderpane.setCenter(Tools.loadPage(fxWeaver, EmployesController.class, AnchorPane.class));
		});
		volCompany.setOnAction(event -> {
			borderpane.setCenter(Tools.loadPage(fxWeaver, VolCompanyController.class, AnchorPane.class));
		});
		hotel.setOnAction(event -> {
			borderpane.setCenter(Tools.loadPage(fxWeaver, HotelController.class, AnchorPane.class));
		});
		voyage.setOnAction(event -> {
			borderpane.setCenter(Tools.loadPage(fxWeaver, VoyagesController.class, AnchorPane.class));
		});
		vol.setOnAction(event -> {
			borderpane.setCenter(Tools.loadPage(fxWeaver, VolsController.class, AnchorPane.class));
		});		accederAuCompte.setOnAction(event ->{
			 Scene scene = new Scene(fxWeaver.loadView(PageChoixConntroller.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
	
		});
	}
	
	
}
