package com.example.stock.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.FactureVol;
import com.example.stock.Bean.FactureVoyage;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.Tools.Tools;
import com.example.stock.dao.FactureVoyageDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("CreeUnVoyage.fxml")
public class CreeUnVoyageController {
	private final FxWeaver fxWeaver;
	private Stage stage;
	@FXML
	private JFXTextField nomClient;
	@FXML
	private JFXTextField prenomClient;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXTextField age;
	@FXML
	private JFXTextField codeClient;
	@FXML
	private JFXButton generer;
	@FXML
	private JFXTextField telephone;
	@FXML
	private Label remise;
	@FXML
	private Button next;
	@FXML
	private Label idDeVoyage;
	@FXML
	private Label message;
	@FXML
	private JFXCheckBox rbMale;
	@FXML
	private JFXCheckBox rbFemale;
	@FXML
	private JFXButton save;
	@FXML
	private JFXComboBox<Integer> ages;
	@FXML
	private AnchorPane creeUnvoyage;
	@Autowired
	private VoyageService voyageService;
	@Autowired
	private VoyageClientService voyageClientService;
	@Autowired
	private UserService userService;
	private final FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView;
	private ObservableList<Integer> Types = FXCollections.observableArrayList();
	@Autowired
	private ClientService clientService;
	private Client client = new Client();
	private VoyageClient voyageClient = new VoyageClient();
	private Long IdC;
	private Voyage voyage1 = new Voyage();

	@FXML
	public void initialize() {
		for (int i = 0; i < 100; i++) {
			Types.add(i);
		}
		ages.setItems(Types);
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
					nomClient.setText(client.getNom());
					prenomClient.setText(client.getPrenom());
					email.setText(client.getEmail());
					ages.setValue(client.getAge());
					if (client.getGender().equals("Male")) {
						rbMale.setSelected(true);
					} else {
						rbFemale.setSelected(true);
					}
					telephone.setText(client.getTelephone());
					remise.setText("vous avez bénificiez d'un remise de fidilité de 10% votre nouveau prix : " + (voyage1.getPrix()-voyage1.getPrix()*(1/10)));
				message.setText("client est trouvé");
				message.setStyle("-fxcolor:#11F264");
				}
	//	add_team4.getController().afficherListe(loginController.user);;
	    
	});
	}

	public String getGender() {
		return rbMale.isSelected() ? "Male" : "Female";
	}

	public void show() {
//		stage.show();
	}

	public CreeUnVoyageController(FxWeaver fxWeaver,
			FxControllerAndView<VoyageListController, AnchorPane> anotherControllerAndView) {
		super();
		this.fxWeaver = fxWeaver;
		this.anotherControllerAndView = anotherControllerAndView;
	}

	public Integer getType() {
		return ages.getSelectionModel().getSelectedItem();
	}

	public void sauvgarderClient(Voyage voyage) {
//		User user=userService.findByLogin(email.getText());
		 voyage1 = voyage;
		//idDeVoyage.setText(String.valueOf(voyage.getId()));

//		show();
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
	    return generatedString;
	}
	private String numero;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	private Double prixnourriture;
	private Double prixHotel;
	private Double prixTotal;
	private Double autre;
	@Autowired
	private FactureVoyageDao factureVoyageDao;
	String codegenerated = null;
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
		}
		this.prixHotel =voyage1.getPrixHotel();
		this.prixnourriture = voyage1.getPrixNourriture();
		this.autre = voyage1.getAutre();
		this.prixTotal = voyage1.getPrix();
		FactureVoyage factureVol = new FactureVoyage();
		factureVol.setAge(getType());
		factureVol.setCodeClient(codeClient.getText());
		factureVol.setDate(new Date());
		voyageClient.setDate(new Date());
		factureVol.setDateDebut(voyage1.getDeteDebut());
		factureVol.setDateDeRetour(voyage1.getDetefin());
		factureVol.setDestination(voyage1.getDestination());
		factureVol.setEmail(email.getText());
		factureVol.setGender(getGender());
		factureVol.setEmail(email.getText());
		factureVol.setNom(nomClient.getText());
		factureVol.setNomHotel(voyage1.getHotel().getNom());
		factureVol.setVolCompany(voyage1.getVolCompany().getNom());
		factureVol.setPrenom(prenomClient.getText());
		factureVol.setGender(getGender());
		factureVol.setUserfirstName(loginController.user.getFirstName());
		factureVol.setUserlasName(loginController.user.getLasName());
		factureVol.setTelephone(telephone.getText());
		if(getType()<10) {
			this.prixHotel =voyage1.getPrixHotel()/2;
			this.prixnourriture = voyage1.getPrixNourriture()/2;
			this.autre = voyage1.getAutre()/2;
			this.prixTotal = voyage1.getPrix()/2;
			System.out.println("ana hna");
					}
		factureVol.setPrixHotel(this.prixHotel);
		factureVol.setPrixNourriture(this.prixnourriture);
		factureVol.setPrix(this.prixTotal);
		factureVol.setAutre(this.autre);
		this.numero = givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
		factureVol.setNumeroFacture(this.numero);
		factureVol.setId(Tools.generateRandomIntIntRange(1, 200));
		factureVoyageDao.save(factureVol);
		voyageClient.setNomVoyage(voyage1.getNomVoyage());
		voyageClient.setCodeClient(codeClient.getText());
		voyageClient.setTelephone(telephone.getText());
		voyageClient.setId(Tools.generateRandomIntIntRange(1, 200));
		voyageClient.setNom(nomClient.getText());
		voyageClient.setPrenom(prenomClient.getText());
		voyageClient.setAge((int)getType());
		voyageClient.setGender(getGender());
		voyageClient.setEmail(email.getText());
		// client.getVoyages().add(voyage);
		// voyageClient.setClient(client);
		// Client client1 = clientService.findByEmail(client.getEmail());
	//	voyageClient.setClient(client);
		voyageClient.setVoyage(voyage1);
	//	voyageService.save(voyage);
		// clientService.save(client1);
		voyageClientService.save(voyageClient);
	}

}