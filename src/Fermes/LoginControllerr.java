package Fermes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginControllerr {
	ArrayList<Utilisateur> data = new ArrayList<Utilisateur>();
	Connecter con = new Connecter();
	@FXML private static JFXTextField Username;
	@FXML private JFXPasswordField password;
	public static String usernamee;
	boolean a=false;

	
	public void login() {
		
		try {
			con.obtenirconnexion();
			String sql = "SELECT * FROM Utilisateur";
			PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				data.add(new Utilisateur(rs.getString("NOM"),rs.getString("Prenom"),rs.getString("Username"),rs.getString("Password"),rs.getInt("Grade")));
				
			}
			/*con.obtenirconnexion().close();*/
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		boolean b=false;
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getPassword().equals(password.getText())&&data.get(i).getUsername().equals(Username.getText())) {
				b=true;
				usernamee=data.get(i).getUsername();
			}else {
			}
		}
		if(b) {
			Parent tableViewParent;
			try {
				tableViewParent = FXMLLoader.load(this.getClass().getResource("Utilisateur_grade1.fxml"));
				Scene scene1 = new Scene(tableViewParent);
				Fermes_interfaces.stage.setScene(scene1);
				/*bienvenue.setText("BIENVENUE !!!");*/
				Fermes_interfaces.stage.show();
				a=true;
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    Fermes_interfaces.stage.show();
		}
	}
	
	
	public void Creeruncomptepage() {
		Parent tableViewParent;
		try {
			tableViewParent = FXMLLoader.load(this.getClass().getResource("CréationDeCompte.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			Fermes_interfaces.stage.setScene(scene1);
			Fermes_interfaces.stage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}


	
}


