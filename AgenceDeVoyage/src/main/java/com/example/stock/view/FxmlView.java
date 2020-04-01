package com.example.stock.view;

import java.util.ResourceBundle;

public enum FxmlView {

    Acceuil {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("Acceuil.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/User.fxml";
        }
    }, 
    VoyageeController{
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("PAGE2.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
