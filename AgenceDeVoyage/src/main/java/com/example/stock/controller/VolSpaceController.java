package com.example.stock.controller;

import org.springframework.stereotype.Component;

import com.example.stock.Bean.Vol;
import com.example.stock.config.PrimaryStageInitializer;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("volSpace.fxml")
public class VolSpaceController {
	private final FxWeaver fxWeaver;

	@FXML
	private AnchorPane volSpace;

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


	public VolSpaceController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}


	@FXML
	public void initialize() {
		retour.setOnAction(actionevent ->{
			Scene scene = new Scene(fxWeaver.loadView(PageChoixConntroller.class));
		       PrimaryStageInitializer.stage.setScene(scene);
		       PrimaryStageInitializer.stage.show();
		});
				//	borderpane.setCenter(Tools.loadPage(fxWeaver, VoyageListController.class, AnchorPane.class));
					FxControllerAndView<volListController, AnchorPane> add_team = fxWeaver.load(volListController.class);
					add_team.getController().afficherListe(lieu);
				    borderpane.setCenter(add_team.getView().get());
				    listevoyage.setStyle("-fx-background-color:#6BD320");
					voyageinfo.setOnAction(
							actionevent2 -> {
								Vol vol = add_team.getController().getselectedItem();
								FxControllerAndView<VolInfoController, AnchorPane> add_team1 = fxWeaver.load(VolInfoController.class);
								add_team1.getController().afficherInfo(vol);
							    borderpane.setCenter(add_team1.getView().get());
							    voyageinfo.setStyle("-fx-background-color:#6BD320");
						//		borderpane.setCenter(Tools.loadPage(fxWeaver, VoyageInfoController.class, AnchorPane.class));

								confirmation.setOnAction(
										actionevent1 -> {
											FxControllerAndView<CreeUnVolController, AnchorPane> add_team2 = fxWeaver.load(CreeUnVolController.class);
											add_team2.getController().sauvgarderClient(vol,add_team1.getController().getPrix());
										    borderpane.setCenter(add_team2.getView().get());
										    confirmation.setStyle("-fx-background-color:#6BD320");
									//		borderpane.setCenter(Tools.loadPage(fxWeaver, CreeUnVoyageController.class, AnchorPane.class));
										    
										    compte.setOnAction(
													actionevent3 -> {
														add_team2.getController().save();
														FxControllerAndView<VolSuccessController, AnchorPane> add_team4 = fxWeaver.load(VolSuccessController.class);
														//add_team4.getController().afficherListe(loginController.user);;
													    borderpane.setCenter(add_team4.getView().get());
													    compte.setStyle("-fx-background-color:#6BD320");
													//	borderpane.setCenter(Tools.loadPage(fxWeaver, UserHistoriqueController.class, AnchorPane.class));

											});
							
								});

					});
	}
	private String lieu;
	public void reserver(String destination) {
	this.lieu = destination;
		borderpane.setLeft(null);
		borderpane.setRight(null);
		borderpane.setBottom(null);
		borderpane.setTop(null);	

	}
}
