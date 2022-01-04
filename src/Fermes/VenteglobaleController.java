package Fermes;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VenteglobaleController {

	
	
	public void VentesAction() {
		Parent tableViewParent;
		try {
			tableViewParent = FXMLLoader.load(this.getClass().getResource("Ventes.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			Fermes_interfaces.stage.setScene(scene1);
			Fermes_interfaces.stage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public void VentesOeufaction() {
			Parent tableViewParent;
			try {
				tableViewParent = FXMLLoader.load(this.getClass().getResource("VenteOeuf.fxml"));
				Scene scene1 = new Scene(tableViewParent);
				Fermes_interfaces.stage.setScene(scene1);
				Fermes_interfaces.stage.show();
				/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void retourVenteGlobale() {
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
		
	
}
