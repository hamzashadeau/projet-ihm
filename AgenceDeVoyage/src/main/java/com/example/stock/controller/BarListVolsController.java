package com.example.stock.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("BarChartVols.fxml")
public class BarListVolsController {
	private final FxWeaver fxWeaver;
	@FXML
	private AnchorPane statibar;
	@FXML
	private Button choisir;
	@FXML
	private BarChart<String,Number> barstati;
//	@FXML
	// private TableColumn<Voyage, String> colNomVol;

	public BarListVolsController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}

	@Autowired
	private VoyageService voyageService;

	@Autowired
	private  VoyageClientService voyageClientService;
	@Autowired
	private ClientVolService clientVolservice;
	@FXML
	public void initialize() {    
	}
	public void getstati() {
		CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Programming Language");
 
        NumberAxis yAxis = new NumberAxis();
          
        yAxis.setLabel("Percent");
 
        // Create a BarChart
         barstati = new BarChart<String, Number>(xAxis, yAxis);
 
        // Series 1 - Data of 2014
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("vol");
        dataSeries1.getData().add(new XYChart.Data<String, Number>("mois " + (new Date().getMonth()+1),clientVolservice.findByMonth((new Date().getMonth()+1)).size()));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("mois " + (new Date().getMonth()),clientVolservice.findByMonth((new Date().getMonth())).size()));

 
        // Series 2 - Data of 2015
       // XYChart.Series<Number, String> dataSeries2 = new XYChart.Series<Number, String>();
        //dataSeries2.setName("Vols");
 
        //dataSeries2.getData().add(new XYChart.Data<Number, String>(clientVolservice.findByMonth((new Date().getMonth()+1)).size(), "mois " + (new Date().getMonth()+1)));
        //dataSeries2.getData().add(new XYChart.Data<Number, String>(clientVolservice.findByMonth((new Date().getMonth())).size(), "mois " + (new Date().getMonth())));

        // Add Series to BarChart.
        barstati.getData().add(dataSeries1);
        //barstati.getData().add(dataSeries2);
 
        barstati.setTitle("Some Programming Languages");
 
        VBox vbox = new VBox(barstati);
        Scene scene = new Scene(vbox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}

	public void show() {
	}

}