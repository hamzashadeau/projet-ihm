package com.example.stock.Bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VoyagePortrait extends GridPane {

	javafx.scene.control.Label label;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public VoyagePortrait(String libelle, String url) throws FileNotFoundException {
		label = new Label();
		
		Image image = new Image(new FileInputStream(url),60,60,true,false);
		ImageView imageView=new ImageView(image);
	//	imageView.setOnMouseClicked(value);
		label.setText(libelle);
		this.add(imageView, 0, 0);
		this.add(label, 0, 1);
	}

}
