package com.example.stock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.stock.controller.Acceuil;
import com.example.stock.controller.AcceuilPrincipal;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent>{

	 private final FxWeaver fxWeaver;
	 private static Stage stage;
	    @Autowired
	    public PrimaryStageInitializer(FxWeaver fxWeaver) {
	        this.fxWeaver = fxWeaver;
	    }

	    @Override
	    public void onApplicationEvent(StageReadyEvent event) {
	        stage = event.stage;
	        Scene scene = new Scene(fxWeaver.loadView(Acceuil.class));
	        stage.setScene(scene);
	        stage.show();
	    }
	    private static void changeScene(Label label, Parent controller) {
	    	label.getScene().getWindow().hide();
	    	Parent root = controller;
	    	Scene scene = new Scene(root);
	    	stage.setScene(scene);
	    	stage.show();
	    	stage.setResizable(false);
	    }
}