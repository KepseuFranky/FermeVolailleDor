package Fermes;



import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginController {
	Connecter con = new Connecter();
	
	
	/*@FXML private JFXTextField Username; 
	@FXML private JFXPasswordField password; 
	@FXML private JFXTextField Usernamecreation; 
	@FXML private JFXPasswordField Passwordcreation;
	@FXML private JFXPasswordField confpassword;
	@FXML private JFXTextField Nomcreation;
	@FXML private JFXTextField prenomcreation;*/
	@FXML private Label bienvenue =  new Label();

	
	
   
    @FXML private JFXButton venteglobale;
    
    private static Stage primaryStage;
    
	
	
	public static 	Utilisateur useractuel= new Utilisateur();
	
	

	
	public void Bandevolailleaction() {
		Parent tableViewParent;
		try {
			tableViewParent = FXMLLoader.load(this.getClass().getResource("Bande2.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			Fermes_interfaces.stage.setScene(scene1);
			Fermes_interfaces.stage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
					public void retourBande2() {
					Parent tableViewParent;
					try {
						tableViewParent = FXMLLoader.load(this.getClass().getResource("Utilisateur_grade1.fxml"));
						Scene scene1 = new Scene(tableViewParent);
						Fermes_interfaces.stage.setScene(scene1);
						Fermes_interfaces.stage.show();
						/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
				
				public void Retourcontrolebande() {
					Parent tableViewParent;
					try {
						tableViewParent = FXMLLoader.load(this.getClass().getResource("Bande2.fxml"));
						Scene scene1 = new Scene(tableViewParent);
						Fermes_interfaces.stage.setScene(scene1);
						Fermes_interfaces.stage.show();
						/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
				
				public void Venteaction() {
					Parent tableViewParent;
					try {
						tableViewParent = FXMLLoader.load(this.getClass().getResource("Vente.fxml"));
						Scene scene1 = new Scene(tableViewParent);
						Fermes_interfaces.stage.setScene(scene1);
						Fermes_interfaces.stage.show();
						/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
	
				public void Cientaction() {
					Parent tableViewParent;
					try {
						tableViewParent = FXMLLoader.load(this.getClass().getResource("Client.fxml"));
						Scene scene1 = new Scene(tableViewParent);
						Fermes_interfaces.stage.setScene(scene1);
						Fermes_interfaces.stage.show();
						/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}			
				
				public void Incubationaction() {
					Parent tableViewParent;
					try {
						tableViewParent = FXMLLoader.load(this.getClass().getResource("Incubation.fxml"));
						Scene scene1 = new Scene(tableViewParent);
						Fermes_interfaces.stage.setScene(scene1);
						Fermes_interfaces.stage.show();
						/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
				
				
				
				
/*@FXML private void initialize() throws IOException/*{
	FXMLLoader  fxmlloader  = new FXMLLoader(this.getClass().getResource("Utilisateur_grade1.fxml"));
	fxmlloader.impl_setStaticLoad(true);
	try {
		fxmlloader.load();
		bienvenue.setText("BIENVENUE "+LoginControllerr.usernamee+" !!!");
	}catch(LoadException e) {
		e.printStackTrace();
	}
	
}*/

/*public void initialize2() throws IOException {
	// TODO Auto-generated method stub
	FXMLLoader  fxmlloader  = new FXMLLoader(this.getClass().getResource("Utilisateur_grade1.fxml"));
	fxmlloader.impl_setStaticLoad(true);
	try {
		fxmlloader.load();
	bienvenue.setText("BIENVENUE "+LoginControllerr.usernamee+" !!!");
	}catch(LoadException e) {
		e.printStackTrace();
	}
}*/
				


				    
				    
	}
