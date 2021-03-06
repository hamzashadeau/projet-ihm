package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Tools.Tools;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("historique.fxml")
public class historiqueController {
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane historiquePage;
	@FXML
	private JFXButton historiqueVols;
	@FXML
	private JFXButton historiqueVoyages;
	@FXML
	private BorderPane boder;
	
	
	public historiqueController(FxWeaver fxWeaver,
			FxControllerAndView<registerLoginController, AnchorPane> anotherControllerAndView1,
			FxControllerAndView<ListeDesEmployesController, AnchorPane> anotherControllerAndView2) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView1 = anotherControllerAndView1;
		this.anotherControllerAndView2 = anotherControllerAndView2;
	}
	@Autowired
	private  VoyageClientService voyageClientService;


	private final FxControllerAndView<registerLoginController, AnchorPane> anotherControllerAndView1;
	private final FxControllerAndView<ListeDesEmployesController, AnchorPane> anotherControllerAndView2;


	public static User user;


	@FXML
	public void initialize() {
		historiqueVoyages.setOnAction(event ->{
			//	FxControllerAndView<BarListController, AnchorPane> add_team = fxWeaver.load(BarListController.class);
			 //   borderpane.setCenter(add_team.getView().get());
			//	anotherControllerAndView1.getController().initialize();;
			boder.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueController.class, AnchorPane.class));			
			});	
		historiqueVols.setOnAction(event ->{
			//	FxControllerAndView<BarListController, AnchorPane> add_team = fxWeaver.load(BarListController.class);
			 //   borderpane.setCenter(add_team.getView().get());
			//	anotherControllerAndView2.getController().initialize();;
				//borderpane.setCenter(Tools.loadPage(fxWeaver, BarListController.class, AnchorPane.class));			
			boder.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueVolController.class, AnchorPane.class));				
		});	
	}
	public void acceuill() {
		//Stage stage1 = new Stage();
	//	stage1.setScene(new Scene(statistiquepage));
	//	stage1.show();		
		
	}
}
