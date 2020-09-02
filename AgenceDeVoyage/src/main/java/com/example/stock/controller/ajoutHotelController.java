package com.example.stock.controller;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.User;
import com.example.stock.Bean.VolCompany;
import com.example.stock.Service.Facade.VolCompanyService;
import com.example.stock.Tools.Tools;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ajoutHotel.fxml")
public class ajoutHotelController {
	private final FxWeaver fxWeaver;
	@FXML
	private JFXTextField nom;
	@FXML
	private TextArea description;
	@FXML
	private JFXTextField email;
	@FXML
	private Label idDeVoyage;
	@FXML
	private Label errornom;
	@FXML
	private Label errordescription;
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
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private JFXTextField lastName;
	@FXML
	private JFXButton save;
	@FXML
	private JFXButton generer;
	@FXML
	private JFXComboBox<Integer> ages;
	@FXML
	private AnchorPane ajoutHotel;
	@FXML
	private BorderPane border;
	@Autowired
	private VolCompanyService volCompanyService;
	private ObservableList<Integer> Types= FXCollections.observableArrayList();
//	private final FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView2;

	private User user = new User();

	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public void show() {
	}

	
	public ajoutHotelController(FxWeaver fxWeaver) {
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
	save.setOnAction(actionEvent -> { 
		if( nom.getText().isEmpty() &&  description.getText().isEmpty())
		{
			errornom.setText("champ vide");
			errordescription.setText("champ vide");
			
		}else if(!nom.getText().isEmpty() &&  !description.getText().isEmpty()){
				VolCompany vol = new VolCompany();
				vol.setNom(nom.getText());
				vol.setId(Tools.generateRandomIntIntRange(1, 200));
				vol.setDescription(description.getText());
			volCompanyService.save(vol);
			message.setText("employe est savgarder");
			message.setStyle("-fxcolor:green");
		//	anotherControllerAndView2.getController().initialize();
			}else {
		if(nom.getText().isEmpty()) {
			errornom.setText("champ vide");
		}
		if(description.getText().isEmpty()) {
			errordescription.setText("champ vide");
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