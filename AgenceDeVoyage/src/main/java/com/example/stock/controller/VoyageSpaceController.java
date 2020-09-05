package com.example.stock.controller;

import java.awt.Color;

import org.springframework.stereotype.Component;

import com.example.stock.Bean.Voyage;
import com.example.stock.Tools.Tools;
import com.example.stock.config.PrimaryStageInitializer;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("voyageSpace.fxml")
public class VoyageSpaceController {
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane voyageSpace;

	@FXML
	private Button compte;
	
	@FXML
	private Button listevoyage;
	
	@FXML
	private Button voyageinfo;
	
	@FXML
	private Button confirmation;
	
	@FXML
	private Button retour;

	@FXML
	private BorderPane borderpane;
	
	
//	private final FxControllerAndView<VoyageInfoController, AnchorPane> anotherControllerAndView1;
	//private final FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView2;
//	private final FxControllerAndView<CreeUnVoyageController, AnchorPane> anotherControllerAndView3;
	//private final FxControllerAndView<UserHistoriqueController, AnchorPane> anotherControllerAndView4;

	public VoyageSpaceController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}


	@FXML
	public void initialize() {
		FxControllerAndView<VoyageListController, AnchorPane> add_team = fxWeaver.load(VoyageListController.class);
		add_team.getController().afficherListe(lieu);
		borderpane.setCenter(add_team.getView().get());
	    listevoyage.setStyle("-fx-background-color:#6BD320");
	    voyageinfo.setOnAction(
				actionevent2 -> {
					Voyage voyage = add_team.getController().getselectedItem();
					FxControllerAndView<VoyageInfoController, AnchorPane> add_team1 = fxWeaver.load(VoyageInfoController.class);
					add_team1.getController().afficherInfo(voyage);
				    borderpane.setCenter(add_team1.getView().get());
			//		borderpane.setCenter(Tools.loadPage(fxWeaver, VoyageInfoController.class, AnchorPane.class));
				    voyageinfo.setStyle("-fx-background-color:#6BD320");

					confirmation.setOnAction(
							actionevent1 -> {
								FxControllerAndView<CreeUnVoyageController, AnchorPane> add_team2 = fxWeaver.load(CreeUnVoyageController.class);
								add_team2.getController().sauvgarderClient(voyage);
							    borderpane.setCenter(add_team2.getView().get());
						//		borderpane.setCenter(Tools.loadPage(fxWeaver, CreeUnVoyageController.class, AnchorPane.class));
							    confirmation.setStyle("-fx-background-color:#6BD320");
							    compte.setOnAction(
										actionevent4 -> {
											add_team2.getController().save();
											FxControllerAndView<VoyageSuccessController, AnchorPane> add_team4 = fxWeaver.load(VoyageSuccessController.class);
										//	add_team4.getController().afficherListe(loginController.user);;
											add_team4.getController().GetNumero(add_team2.getController().getNumero());
										    borderpane.setCenter(add_team4.getView().get());
										//	borderpane.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueController.class, AnchorPane.class));
										    compte.setStyle("-fx-background-color:#6BD320");

										});
							    
					});

		});
	    retour.setOnAction(event ->{
	    	 Scene scene = new Scene(fxWeaver.loadView(PageChoixConntroller.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
	    });

	}
	private String lieu;
	public void reserver(String destination) {
		this.lieu = destination;
		borderpane.setLeft(null);
		borderpane.setRight(null);
		borderpane.setBottom(null);
		borderpane.setTop(null);
	
				//	borderpane.setCenter(Tools.loadPage(fxWeaver, VoyageListController.class, AnchorPane.class));
						
		

	}
}
