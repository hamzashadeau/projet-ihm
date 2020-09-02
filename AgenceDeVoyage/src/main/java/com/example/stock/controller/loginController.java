package com.example.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.config.PrimaryStageInitializer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("login.fxml")
public class loginController {

	private final FxWeaver fxWeaver;
	@FXML
	private JFXTextField login;
	@FXML
	private JFXPasswordField password;
	@FXML
	private AnchorPane loginpage;
	@FXML
	private JFXButton connecter;
	@FXML
	private Label errorlogin;
	@FXML
	private Label errormdp;
	
	@Autowired
	private VoyageService voyageService;
	@Autowired
	private UserService userService;

	private final FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView1;

	public static User user;


	public loginController(FxWeaver fxWeaver, FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView1) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView1 = anotherControllerAndView1;
	}

	@FXML
	public void initialize() {
	//	login.setOnMouseClicked(actionevent ->{
		//	login.setStyle("-fx-max-width: 300");
		//	login.setStyle("-fx-border-radius: 25");

		//});
		//password.setOnMouseClicked(actionevent ->{
			//password.setStyle("-fx-max-width: 300");
		//	password.setStyle("-fx-border-radius: 25");

		//});
//		Stage stage = new Stage();
	//stage.setScene(new Scene(loginpage));
		connecter.setOnAction(actionEvent -> { 
			if(!login.getText().isEmpty() && !password.getText().isEmpty()) {
				user = userService.findByLogin(login.getText());
				System.out.println(user.getMotDePass());
				String mdp = password.getText();
				if (user.getMotDePass().equals(mdp)) {
					Scene scene = new Scene(fxWeaver.loadView(PageChoixConntroller.class));
				       PrimaryStageInitializer.stage.setScene(scene);
				       PrimaryStageInitializer.stage.show();
				//	anotherControllerAndView1.getController().spacecompte();
					//Acceuil.border.setCenter(Tools.loadPage(fxWeaver, AcceuilPrincipal.class, AnchorPane.class));
				}}else {
			if(login.getText().isEmpty()) {
				errorlogin.setText("champ vide");
			}				 
			if(password.getText().isEmpty()) {
				errormdp.setText("champ vide");
			} 
			}});
	}

//anotherControllerAndView.getController().afficherlesvoyage(destination.getText());

}
