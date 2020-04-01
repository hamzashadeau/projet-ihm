package com.example.stock.controller;

import org.springframework.stereotype.Component;

import com.example.stock.Tools.Tools;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("comptespace.fxml")
public class CompteSpaceController {
	
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane CompteSpacee;

	@FXML
	private Button edit;
	
	@FXML
	private Button voyagehistorique;
	
	@FXML
	private Button volhistorique;
	
	@FXML
	private Label moi;
	@FXML
	private Button logout;

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
	Stage stage1 = new Stage();
	stage1.setScene(new Scene(CompteSpacee));
	stage1.show();
	moi.setText(loginController.user.getFirstName()+loginController.user.getLasName());
	borderpane.setLeft(null);
	borderpane.setRight(null);
	borderpane.setBottom(null);
	borderpane.setTop(null);
	edit.setOnAction(
			actionevent ->{
			borderpane.setCenter(Tools.loadPage(fxWeaver, editUserController.class, AnchorPane.class));
	});
	voyagehistorique.setOnAction(
			actionevent ->{
		borderpane.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueController.class, AnchorPane.class));

	});
	volhistorique.setOnAction(
			actionevent ->{
		borderpane.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueVolController.class, AnchorPane.class));

	});
	logout.setOnAction(actionevent ->{
		stage1.close();
		loginController.user = null;
	});
}
	@FXML
	public void initialize() {

		

	}
	
	
}
