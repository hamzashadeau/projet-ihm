package com.example.stock.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class stageManager {
	public static void changeScene(Label label, Parent controller) {
    	label.getScene().getWindow().hide();
    	Parent root = controller;
    	Scene scene = new Scene(root);
    	PrimaryStageInitializer.stage.setScene(scene);
    	PrimaryStageInitializer.stage.show();
    	PrimaryStageInitializer.stage.setResizable(false);
    }
}
