package com.example.stock.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.example.stock.Bean.FactureVol;
import com.example.stock.dao.FactureVolDao;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
@FxmlView("volSucess.fxml")
public class VolSuccessController {
	@FXML
private AnchorPane volsuccess;
	private final FxWeaver fxWeaver;

@Autowired
private FactureVolDao factureVolDao;
@FXML
public void initialize() {
	imprimer.setOnAction(event ->{
		try {
			exportReport("pdf");
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
//	stage = new Stage();
	//stage.setScene(new Scene(volliste));
}
public void show() {
}
private String numero;
public void GetNumero(String numeroFacture) {
	this.numero = numeroFacture;
}
@FXML
private JFXButton imprimer;
public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
    //String path = "C:\Users\basan\Desktop\Report";
    List<FactureVol> employees = factureVolDao.findByNumeroFacture(numero);
    //load file and compile it
    java.io.File file = ResourceUtils.getFile("classpath:facture.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("createdBy", "Java Techie");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    if (reportFormat.equalsIgnoreCase("html")) {
        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
    }
    if (reportFormat.equalsIgnoreCase("pdf")) {
        JasperExportManager.exportReportToPdfFile(jasperPrint,"facture.pdf");
    }

    return "report generated in path : " ;
}
public VolSuccessController(FxWeaver fxWeaver) {
	super();
	this.fxWeaver = fxWeaver;
}

}
