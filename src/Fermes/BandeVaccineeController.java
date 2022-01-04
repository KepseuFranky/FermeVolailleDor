package Fermes;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BandeVaccineeController {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<Bandevaccinee> tablecontrolebandevaccinee ;
	@FXML private TableColumn<Bandevaccinee, Integer> cidBandeVaccine;
	@FXML private TableColumn<Bandevaccinee, Integer> cbande_id; 
	@FXML private TableColumn<Bandevaccinee, Integer> cvaccin_id;
	@FXML private TableColumn<Bandevaccinee, String> cdateVac;

	ObservableList<Bandevaccinee> databandevaccinee = FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idBandeVaccine;
	@FXML private TextField dateVac;
	@FXML private TextField bande_id;
	@FXML private TextField vaccin_id;
	
	
	
	
	public void actualiser() {
		databandevaccinee.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		databandevaccinee.clear();
		String sql = "SELECT * FROM bandevaccine";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			databandevaccinee.add(new Bandevaccinee(rs.getInt("idBandeVaccine"),rs.getInt("bande_id"),rs.getInt("vaccin_id"),rs.getString("dateVac")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidBandeVaccine.setCellValueFactory(new PropertyValueFactory<Bandevaccinee, Integer>("idBandeVaccine"));
		cbande_id.setCellValueFactory(new PropertyValueFactory<Bandevaccinee, Integer>("bande_id"));
		cvaccin_id.setCellValueFactory(new PropertyValueFactory<Bandevaccinee, Integer>("vaccin_id"));
		cdateVac.setCellValueFactory(new PropertyValueFactory<Bandevaccinee, String>("dateVac"));
		tablecontrolebandevaccinee.setItems(databandevaccinee);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterbandevaccinee () /*throws IOException*/{
		
		
		try {
			
			/*boolean exist=false;
			int i=0;
           while (i<data.size()) {
            	if(datacontrolebande.get(i).id==Integer.parseInt(idt.getText())) {
            		exist=true;
            	}
            	i++;
            }*/
           /*if(!exist) {*/
		String query="INSERT INTO bandevaccine(idBandeVaccine,bande_id,vaccin_id,dateVac) values ("+Integer.parseInt(idBandeVaccine.getText())+","+Integer.parseInt(bande_id.getText())+","+Integer.parseInt(vaccin_id.getText())+","+dateVac.getText()+")";
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
			
			actualiser();
			
           
        	   
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
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	            e.printStackTrace();
		}
	}
	
	
	
	public void Newcontrolebandevaccineeaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("NewBandeVaccinee.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			primarystage.setScene(scene1);
			primarystage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void supprimer() {   
		ObservableList<Bandevaccinee> sel;
		ObservableList<Bandevaccinee> items;   
		Bandevaccinee e = new Bandevaccinee();
	items = tablecontrolebandevaccinee.getItems();  
	sel = tablecontrolebandevaccinee.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Bandevaccine WHERE idBandeVaccine = "+e.getIdBandeVaccine();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (Bandevaccinee m : sel)   
	{        
		items.remove(m);    
	} 
	}
	
	
	public void RetourbandeVaccinee() {
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
	

public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
