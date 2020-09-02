package com.example.stock.controller;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Employe;
import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Tools.Tools;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("registerUser.fxml")
public class registerLoginController {
	private final FxWeaver fxWeaver;
	@FXML
	private JFXTextField firstName;
	@FXML
	private JFXTextField cin;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXTextField adress;
	@FXML
	private JFXTextField telephone;
	@FXML
	private JFXTextField codeEmploye;
	@FXML
	private JFXTextField age;
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
	private Label errortelephone;
	@FXML
	private Label message;
	@FXML
	private Label errorcin;
	@FXML
	private JFXCheckBox rbMale;
	@FXML
	private JFXCheckBox rbFemale;
	@FXML
	private JFXTextField lastName;
	@FXML
	private JFXButton save;
	@FXML
	private JFXButton generer;
	@FXML
	private JFXComboBox<Integer> ages;
	@FXML
	private AnchorPane creeUnUser;
	@FXML
	private BorderPane border;
	@Autowired
	private EmployeService employeService;
	private ObservableList<Integer> Types= FXCollections.observableArrayList();
//	private final FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView2;

	private User user = new User();

	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public void show() {
	}

	
	public registerLoginController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}
	public String givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    System.out.println(generatedString);
	    return generatedString;
	}
	String codegenerated = null;
	public void start() {
		//Stage stage = new Stage();
		//stage.setScene(new Scene(creeUnUser));
		//stage.show();
	}
	@FXML
	public void initialize() {
		for (int i = 0; i < 100; i++) {
			Types.add(i);
		}
	ages.setItems(Types);
	generer.setOnAction(event ->{
		 codegenerated = this.givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
		codeEmploye.setText(codegenerated);
	});
	codeEmploye.setOnKeyPressed(event ->{
		Employe employefonded = employeService.findByCodeEmploye(codeEmploye.getText());
		if(employefonded == null) {
			message.setText("employe introvable");
			message.setStyle("-fxcolor:red");
		}else {
			firstName.setText(employefonded.getPrenom());
			lastName.setText(employefonded.getNom());
			adress.setText(employefonded.getAdress());
			cin.setText(employefonded.getCin());
			telephone.setText(employefonded.getTelephone());
			ages.setValue(employefonded.getAge());
			if (employefonded.getGender().equals("Male")) {
				rbMale.setSelected(true);
			} else {
				rbFemale.setSelected(true);
			}	
			message.setText("employe est trouvé");
			message.setStyle("-fxcolor:#11F264");
			}
	});
	save.setOnAction(actionEvent -> { 
		if( firstName.getText().isEmpty() &&  lastName.getText().isEmpty() && adress.getText().isEmpty() && 
				email.getText().isEmpty() && cin.getText().isEmpty() && telephone.getText().isEmpty() && getGender().isEmpty() && getType() == null)
		{
			errorfirstname.setText("champ vide");
			errorlastname.setText("champ vide");
			erroradress.setText("champ vide");
			eroremail.setText("champ vide");
			telephone.setText("champ vide");
			cin.setText("champ vide");
		}else if(!firstName.getText().isEmpty() &&  !lastName.getText().isEmpty() && !adress.getText().isEmpty() && !email.getText().isEmpty() && 
				!telephone.getText().isEmpty() && !cin.getText().isEmpty() && !getGender().isEmpty() && getType() != null){
			if(validate("First Name", firstName.getText(), "[a-zA-Z]+",errorfirstname) &&
			    	   validate("Last Name",lastName.getText() , "[a-zA-Z]+",errorlastname) &&
			    	   validate("Email", email.getText(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+",eroremail)){
				Employe employe = new Employe();
				employe.setCodeEmploye(codegenerated);
				employe.setId(Tools.generateRandomIntIntRange(1, 200));
				employe.setPrenom(firstName.getText());
				employe.setNom(lastName.getText());
			employe.setAdress(adress.getText());
			employe.setAge(getType());
			employe.setEmail(email.getText());
			employe.setGender(getGender());
			employe.setTelephone(telephone.getText());
			employe.setCin(cin.getText());
			employeService.save(employe);
			message.setText("employe est savgarder");
			message.setStyle("-fxcolor:green");
		//	anotherControllerAndView2.getController().initialize();
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
		if(cin.getText().isEmpty()) {
			errorcin.setText("champ vide");
		}
		if(telephone.getText().isEmpty()) {
			errortelephone.setText("champ vide");
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