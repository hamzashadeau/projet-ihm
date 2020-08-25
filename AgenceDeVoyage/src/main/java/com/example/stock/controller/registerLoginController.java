package com.example.stock.controller;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Tools.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("registerUser.fxml")
public class registerLoginController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private TextField firstName;
	@FXML
	private TextField email;
	@FXML
	private TextField adress;
	@FXML
	private TextField motpass;
	@FXML
	private TextField motDepassCon;
	@FXML
	private TextField age;
	@FXML
	private Label idDeVoyage;
	@FXML
	private Label errorid;
	@FXML
	private Label errorfirstname;
	@FXML
	private Label erroradress;
	@FXML
	private Label errorlastname;
	@FXML
	private Label eroremail;
	@FXML
	private Label errormdp;
	@FXML
	private Label errorcmdp;
	@FXML
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private TextField lastName;
	@FXML
	private Button save;
	@FXML
	private ComboBox<Integer> ages;
	@FXML
	private AnchorPane creeUnUser;
	@FXML
	private BorderPane border;
	@Autowired
	private UserService userService;
	private ObservableList<Integer> Types= FXCollections.observableArrayList();
	private final FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView2;

	private User user = new User();

	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public void show() {
	}

	public registerLoginController(FxWeaver fxWeaver,
			FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView1) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView2 = anotherControllerAndView1;
	}
	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}
	@FXML
	public void initialize() {
		stage = new Stage();
		stage.setScene(new Scene(creeUnUser));
		for (int i = 0; i < 100; i++) {
			Types.add(i);
		}
	ages.setItems(Types);
	
	
	save.setOnAction(actionEvent -> { 
		if( firstName.getText().isEmpty() &&  lastName.getText().isEmpty() && adress.getText().isEmpty() && 
				email.getText().isEmpty() && motpass.getText().isEmpty() && motDepassCon.getText().isEmpty() && getGender().isEmpty() && getType() == null)
		{
			errorfirstname.setText("champ vide");
			errorlastname.setText("champ vide");
			erroradress.setText("champ vide");
			eroremail.setText("champ vide");
			errormdp.setText("champ vide");
			errorcmdp.setText("champ vide");
		}else if(!firstName.getText().isEmpty() &&  !lastName.getText().isEmpty() && !adress.getText().isEmpty() && !email.getText().isEmpty() && 
				!motpass.getText().isEmpty() && !motDepassCon.getText().isEmpty() && !getGender().isEmpty() && getType() != null){
			if(validate("First Name", firstName.getText(), "[a-zA-Z]+",errorfirstname) &&
			    	   validate("Last Name",lastName.getText() , "[a-zA-Z]+",errorlastname) &&
			    	   validate("Email", email.getText(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+",eroremail)){
				user.setId(Tools.generateRandomIntIntRange(1, 200));
				user.setFirstName(firstName.getText());
			user.setLasName(lastName.getText());
			user.setAdress(adress.getText());
			user.setAge(getType());
			user.setLogin(email.getText());
			user.setGender(getGender());
			user.setMotDePass(motpass.getText());
			userService.save(user);
			anotherControllerAndView2.getController().initialize();
			}}else {
		if(firstName.getText().isEmpty()) {
			errorfirstname.setText("champ vide");
		}
		if(lastName.getText().isEmpty()) {
			errorlastname.setText("champ vide");
		}
		if(adress.getText().isEmpty()) {
			erroradress.setText("champ vide");
		}
		if(email.getText().isEmpty()) {
			eroremail.setText("champ vide");
		}
		if(motpass.getText().isEmpty()) {
			errormdp.setText("champ vide");
		}
		if(motDepassCon.getText().isEmpty()) {
			errorcmdp.setText("champ vide");
		}
		if(!motpass.getText().equals(motDepassCon.getText())) {
			errorcmdp.setText("champ incompatible");
		}
		}
	});
	}
	private boolean validate(String field, String value, String pattern,Label label){
			Pattern p = Pattern.compile(pattern);
	        Matcher m = p.matcher(value);
	        if(m.find() && m.group().equals(value)){
	            return true;
	        }else{
              label.setText("invalid");
	        	return false;            
	        }
	}
}