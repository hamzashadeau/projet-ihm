package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.VoyageClientService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("statistiqueAcceuil.fxml")
public class AcceuilStatistiqueController {
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane statistiquepage;
	@FXML
	private Button bar;
	@FXML
	private Button barVol;
	
	
	public AcceuilStatistiqueController(FxWeaver fxWeaver,
			FxControllerAndView<BarListController, AnchorPane> anotherControllerAndView1,
			FxControllerAndView<BarListVolsController, AnchorPane> anotherControllerAndView2) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView1 = anotherControllerAndView1;
		this.anotherControllerAndView2 = anotherControllerAndView2;
	}
	@Autowired
	private  VoyageClientService voyageClientService;


	private final FxControllerAndView<BarListController, AnchorPane> anotherControllerAndView1;
	private final FxControllerAndView<BarListVolsController, AnchorPane> anotherControllerAndView2;


	public static User user;


	@FXML
	public void initialize() {
		bar.setOnAction(event ->{
			//	FxControllerAndView<BarListController, AnchorPane> add_team = fxWeaver.load(BarListController.class);
			 //   borderpane.setCenter(add_team.getView().get());
				anotherControllerAndView1.getController().getstati();
				//borderpane.setCenter(Tools.loadPage(fxWeaver, BarListController.class, AnchorPane.class));			
			});	
		barVol.setOnAction(event ->{
			//	FxControllerAndView<BarListController, AnchorPane> add_team = fxWeaver.load(BarListController.class);
			 //   borderpane.setCenter(add_team.getView().get());
				anotherControllerAndView2.getController().getstati();
				//borderpane.setCenter(Tools.loadPage(fxWeaver, BarListController.class, AnchorPane.class));			
			});	
	}
	public void acceuill() {
		//Stage stage1 = new Stage();
	//	stage1.setScene(new Scene(statistiquepage));
	//	stage1.show();		
		
	}
}
