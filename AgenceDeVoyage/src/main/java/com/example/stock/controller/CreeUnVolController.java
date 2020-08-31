package com.example.stock.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.User;
import com.example.stock.Bean.Vol;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Service.Facade.VolService;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("CreeUnVol.fxml")
public class CreeUnVolController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private TextField nomClient;
	@FXML
	private TextField prenomClient;
	@FXML
	private TextField email;
	@FXML
	private TextField age;
	@FXML
	private Label idDeVoyage;
	@FXML
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private TextField codeClient;
	@FXML
	private Button generer;
	@FXML
	private Label remise;
	@FXML
	private ComboBox<Integer> ages;
	@FXML
	private Button save;
	@FXML
	private AnchorPane creeUnvol;
	@Autowired
	private ClientService clientService;
	@FXML
	private Label message;
	@FXML
	private TextField telephone;
	@Autowired
	private VolService volService;
	@Autowired
	private UserService userService;
	private ObservableList<Integer> Typess = FXCollections.observableArrayList();
	@Autowired
	private ClientVolService clientVolService;
	private ClientVol clientVol = new ClientVol();
	private User user = new User();
private Vol vol1 = new Vol();
private Double prixmod; 
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
    return generatedString;
}
String codegenerated = null;

	@FXML
	public void initialize() {
		generer.setOnAction(event ->{
			 codegenerated = this.givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
			codeClient.setText(codegenerated);
		});
		codeClient.setOnKeyPressed(event ->{
			Client employefonded = clientService.findByCodeClient(codeClient.getText());
			if(employefonded == null) {
				message.setText("client introvable");
				message.setStyle("-fxcolor:red");
			}else {
					nomClient.setText(employefonded.getNom());
					prenomClient.setText(employefonded.getPrenom());
					email.setText(employefonded.getEmail());
					ages.setValue(employefonded.getAge());
					if (employefonded.getGender().equals("Male")) {
						rbMale.setSelected(true);
					} else {
						rbFemale.setSelected(true);
					}
					telephone.setText(employefonded.getTelephone());
					remise.setText("vous avez bénificiez d'un remise de fidilité de 10% votre nouveau prix : " + (vol1.getPrix()-vol1.getPrix()*(1/10)));
				message.setText("client est trouvé");
				message.setStyle("-fxcolor:#11F264");
				}
		});
	//	stage = new Stage();
		//stage.setScene(new Scene(creeUnvol));
		for (int i = 0; i < 100; i++) {
			Typess.add(i);
		}
		ages.setItems(Typess);
	}

	public void show() {
	//	stage.show();
	}

	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}
	public String getGender(){
		return rbMale.isSelected() ? "Male" : "Female";
	}
	public CreeUnVolController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
	public void sauvgarderClient(Vol vol,String prix) {
//User user = loginController.user;
vol1 = vol;
//idDeVoyage.setText(String.valueOf(vol.getId()));
 prixmod = new Double(prix);
//		show();
	}
	Client client = new Client();
	public void save() {
		if(this.codegenerated != null) {
			client.setCodeClient(codeClient.getText());
			client.setTelephone(telephone.getText());
			client.setId(Tools.generateRandomIntIntRange(1, 200));
			client.setNom(nomClient.getText());
			client.setPrenom(prenomClient.getText());
			client.setAge((int)getType());
			client.setGender(getGender());
			client.setEmail(email.getText());
			clientService.save(client);
		}		clientVol.setId(Tools.generateRandomIntIntRange(1, 200));
			clientVol.setNom(nomClient.getText());
			clientVol.setPrenom(prenomClient.getText());
			clientVol.setiDVol(vol1.getId());
			// int Age = Integer.parseInt(age.getText());
			clientVol.setAge(getType());
			clientVol.setGender(getGender());
			clientVol.setEmail(email.getText());
			clientVol.setTelephone(telephone.getText());
			clientVol.setCodeClient(codeClient.getText());
			clientVol.setVol(vol1);
			clientVol.getVol().setPrix(prixmod);
			clientVolService.save(clientVol);
			user.getVols().add(vol1);
	}
}