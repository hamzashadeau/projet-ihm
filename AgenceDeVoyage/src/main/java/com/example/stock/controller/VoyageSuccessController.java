package com.example.stock.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("voyageSucess.fxml")
public class VoyageSuccessController {
	@FXML
	private AnchorPane voyageSuceess;
	private final FxWeaver fxWeaver;

	public VoyageSuccessController(FxWeaver fxWeaver) {
		super();
		this.fxWeaver = fxWeaver;
	}
	@FXML
	public void initialize() {
//		stage = new Stage();
		//stage.setScene(new Scene(volliste));
	}
	public void show() {
		
	}
	
}
