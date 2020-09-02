package com.example.stock.controller;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Hotel;
import com.example.stock.Bean.User;
import com.example.stock.Bean.VolCompany;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.HotelService;
import com.example.stock.Service.Facade.VolCompanyService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.Tools.Tools;
import com.example.stock.dao.HotelDao;
import com.example.stock.dao.VolCompanyDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ajouterUnVoyage.fxml")
public class ajouterUnVoyageController {
	private final FxWeaver fxWeaver;
	@FXML
	private JFXTextField nomVoyage;
	@FXML
	private TextArea description;
	@FXML
	private JFXTextField destination;
	@FXML
	private JFXTextField prix;
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
	private Label errornom;
	@FXML
	private Label errordestination;
	@FXML
	private Label erorvolCompany;
	@FXML
	private Label errordateDebut;
	@FXML
	private Label errorHotel;
	@FXML
	private Label message;
	@FXML
	private Label errorprix;
	@FXML
	private Label errorDescription;
	@FXML
	private Label errordateFin;
	@FXML
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private DatePicker dateDebut;
	@FXML
	private DatePicker dateFin;
	@FXML
	private JFXButton save;
	@FXML
	private JFXButton generer;
	@FXML
	private JFXComboBox<String> volCombo;
	@FXML
	private JFXComboBox<String> hotelCombo;
	@FXML
	private AnchorPane ajoutVoyage;
	@FXML
	private BorderPane border;
	@Autowired
	private VoyageService voyageService;
	private HotelService hotelService;
	private VolCompanyService volCompanyService;
	private ObservableList<String> vols= FXCollections.observableArrayList();
	private ObservableList<String> hotels= FXCollections.observableArrayList();
//	private final FxControllerAndView<CompteSpaceController, AnchorPane> anotherControllerAndView2;

	private User user = new User();

	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public void show() {
	}

	
	public ajouterUnVoyageController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
	public String getVol() {
		return volCombo.getSelectionModel().getSelectedItem();
	}
	public String getHotel() {
		return hotelCombo.getSelectionModel().getSelectedItem();
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
	public void start() {
		//Stage stage = new Stage();
		//stage.setScene(new Scene(creeUnUser));
		//stage.show();
	}
	@Autowired
	private VolCompanyDao volCompanyDao;
	@Autowired
	private HotelDao hotelDao;
	@FXML
	public void initialize() {
		List<VolCompany> volss = volCompanyDao.findAll();
	if(volss!= null) {
		for (VolCompany volCompany : volss) {
			vols.add(volCompany.getNom());
		}			
		volCombo.setItems(vols);
		}
		List<Hotel> hotels = hotelDao.findAll();
	for (Hotel hotel : hotels) {
		this.hotels.add(hotel.getNom());
	}
	hotelCombo.setItems(this.hotels);
	
	save.setOnAction(actionEvent -> { 
		if( nomVoyage.getText().isEmpty() &&  destination.getText().isEmpty() && prix.getText().isEmpty() && 
				getHotel().isEmpty() && getVol().isEmpty()&& description.getText().isEmpty()&& dateDebut.getValue()==null&& dateFin.getValue()== null)
		{
			errordestination.setText("champ vide");
			errorHotel.setText("champ vide");
			errornom.setText("champ vide");
			errorprix.setText("champ vide");
			errorDescription.setText("champ vide");
		}else if(!nomVoyage.getText().isEmpty() &&  !destination.getText().isEmpty() && !prix.getText().isEmpty() && !getHotel().isEmpty() && 
				!getVol().isEmpty() && !description.getText().isEmpty() && !getGender().isEmpty()&&dateDebut.getValue()!=null&& dateFin.getValue()!= null){
				Voyage voyage = new Voyage();
				voyage.setId(Tools.generateRandomIntIntRange(1, 200));
				voyage.setNomVoyage(nomVoyage.getText());
				voyage.setDescription(description.getText());
				List<Hotel> hotel = hotelService.findByNom(getHotel());
				for (Hotel hotel2 : hotel) {
					voyage.setHotel(hotel2);					
				}
				List<VolCompany> vol = volCompanyService.findByNom(getVol());
				for (VolCompany vol2 : vol) {
					voyage.setVolCompany(vol2);					
				}
				ZoneId defaultZoneId = ZoneId.systemDefault();
			voyage.setPrix(Double.parseDouble(prix.getText()));
			voyage.setDetefin(Date.from(dateFin.getValue().atStartOfDay(defaultZoneId).toInstant()));
			voyage.setDeteDebut(Date.from(dateDebut.getValue().atStartOfDay(defaultZoneId).toInstant()));
			voyageService.save(voyage);
			message.setText("employe est savgarder");
			message.setStyle("-fxcolor:green");
		//	anotherControllerAndView2.getController().initialize();
			}else {
		if(nomVoyage.getText().isEmpty()) {
			errornom.setText("champ vide");
		}
		if(description.getText().isEmpty()) {
			errorDescription.setText("champ vide");
		}
		if(destination.getText().isEmpty()) {
			errordestination.setText("champ vide");
		}
		if(prix.getText().isEmpty()) {
			errorprix.setText("champ vide");
		}
		if(getHotel().isEmpty()) {
			errorHotel.setText("champ vide");
		}
		if(getVol().isEmpty()) {
			erorvolCompany.setText("champ vide");
		}
		if(dateDebut.getValue() == null) {
			errordateDebut.setText("champ vide");
		}
		if(dateFin.getValue() == null) {
			errordateFin.setText("champ vide");
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