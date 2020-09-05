package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
	private JFXButton bar;
	@FXML
	private JFXButton barVol;
	@FXML
	private Label nbrVoyage;
	@FXML
	private Label GenderMen;
	@FXML
	private Label GenderWoman;
	@FXML
	private Label nbrVol;
	
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

@Autowired
private ClientVolService clientVolService;
@Autowired
private EmployeService employeService;
	@FXML
	public void initialize() {
		int nbr =voyageClientService.findAll().size();
		this.nbrVoyage.setText(String.valueOf(nbr));
		int nbrVol =clientVolService.findAll().size();
		this.nbrVol.setText(String.valueOf(nbrVol));
		int nbrEmployeMen =employeService.findByGender("male").size();
		this.GenderMen.setText(String.valueOf(nbrEmployeMen));
		int nbrEmployeWoman =employeService.findByGender("female").size();
		this.GenderWoman.setText(String.valueOf(nbrEmployeWoman));
		
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
