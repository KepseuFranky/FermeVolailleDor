package Fermes;


import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*; 
import javafx.scene.*;
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.geometry.*;

public class Fermes_interfaces extends Application  {

	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage)    {
		stage=primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FermeInterfaceN.fxml"));
			Scene scene = new Scene(root);
	    	primaryStage.setScene(scene);        
	    	primaryStage.show();
	    	
	    	
	    	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
