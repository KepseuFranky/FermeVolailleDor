package Fermes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CreationCompteController {
	@FXML private JFXTextField Username; 
	@FXML private JFXPasswordField password; 
	@FXML private JFXTextField Usernamecreation; 
	@FXML private JFXPasswordField Passwordcreation;
	@FXML private JFXPasswordField confpassword;
	@FXML private JFXTextField Nomcreation;
	@FXML private JFXTextField prenomcreation;
	ArrayList<Utilisateur> data = new ArrayList<Utilisateur>();
	Connecter con = new Connecter();
	
	
	public void Creercompte () /*throws IOException*/{
		
		
		try {
			data.clear();
			String sql = "SELECT * FROM Utilisateur";
			PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				data.add(new Utilisateur(rs.getString("NOM"),rs.getString("Prenom"),rs.getString("Username"),rs.getString("Password"),rs.getInt("Grade")));
				
			}
			boolean exist=false;
			int i=0;
           while (i<data.size()) {
            	if(data.get(i).getPassword().equals(Passwordcreation.getText()) && data.get(i).getUsername().equals(Usernamecreation.getText())) {
            		exist=true;
            	}
            	i++;
            }
           if(!exist && Passwordcreation.getText().equals(confpassword.getText())) {
		String query="INSERT INTO utilisateur(Nom,preNom,username,password,grade) values ('"+Nomcreation.getText()+"','"+prenomcreation.getText()+"','"+Usernamecreation.getText()+"','"+Passwordcreation.getText()+"',"+2+")";
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
			transmission2.executeUpdate(query);
			/*try {
				Parent	tableViewParent = FXMLLoader.load(this.getClass().getResource("ajout.fxml"));
				Scene scene = new Scene(tableViewParent);
				stage.setScene(scene);
                stage.showAndWait();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("VOTRE COMPTE A ETE CREE AVEC SUCCES !!!");
			alert.showAndWait();
			
           }else {
        	   if(!Passwordcreation.getText().equals(confpassword.getText())) {
        		   Alert alert = new Alert(AlertType.INFORMATION);
		   			alert.setTitle("Information");
		   			alert.setHeaderText(null);
		   			alert.setContentText("Vous n'avez pas correctement confirmer le mot de passe");
		   			alert.showAndWait();
        	   }else {
        	   
				/*try {       
			       stage.initModality(Modality.APPLICATION_MODAL);
					Parent tableViewParent = FXMLLoader.load(this.getClass().getResource("existal.fxml"));
					Scene scene = new Scene(tableViewParent);
	                  stage.setScene(scene);
	                  stage.showAndWait();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
        	   Alert alert = new Alert(AlertType.INFORMATION);
   			alert.setTitle("Information");
   			alert.setHeaderText(null);
   			alert.setContentText("Un compte avec le meme nom d'utilisateur et le meme mot de passe existe déjà");
   			alert.showAndWait();
            }
           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Retour() {
		Parent tableViewParent;
		try {
			tableViewParent = FXMLLoader.load(this.getClass().getResource("FermeInterfaceN.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			Fermes_interfaces.stage.setScene(scene1);
			Fermes_interfaces.stage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
}
