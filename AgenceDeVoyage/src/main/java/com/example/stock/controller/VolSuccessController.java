package com.example.stock.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("volSucess.fxml")
public class VolSuccessController {
	@FXML
private AnchorPane volsuccess;
	private final FxWeaver fxWeaver;


@FXML
public void initialize() {
//	stage = new Stage();
	//stage.setScene(new Scene(volliste));
}
public void show() {
	
}
public VolSuccessController(FxWeaver fxWeaver) {
	super();
	this.fxWeaver = fxWeaver;
}

}
