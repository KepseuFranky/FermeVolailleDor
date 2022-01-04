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

public class ClientController {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<Client> tableClient ;
	@FXML private TableColumn<Client, Integer> cidClient;
	@FXML private TableColumn<Client, String> cadresse; 
	@FXML private TableColumn<Client, Integer> ctel;

	ObservableList<Client> dataClient= FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idClient;
	@FXML private TextField adresse;
	@FXML private TextField tel;
	
	
	
	
	public void actualiserClient() {
		dataClient.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		dataClient.clear();
		String sql = "SELECT * FROM Client";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			dataClient.add(new Client(rs.getInt("idClient"),rs.getString("adresse"),rs.getInt("tel")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidClient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idClient"));
		cadresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresse"));
		ctel.setCellValueFactory(new PropertyValueFactory<Client, Integer>("tel"));
		tableClient.setItems(dataClient);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterclient () /*throws IOException*/{
		
		
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
			
			
			
			
		String query="INSERT INTO Client(idClient,adresse,tel) values ("+Integer.parseInt(idClient.getText())+","+adresse.getText()+","+Integer.parseInt(tel.getText())+")";
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
			
			actualiserClient();
			
           
        	   
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
	
	
	
	public void NewClientaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("NewClient.fxml"));
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
		ObservableList<Client> sel;
		ObservableList<Client> items;   
		Client e = new Client();
	items = tableClient.getItems();
	sel = tableClient.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Client WHERE idClient = "+e.getIdClient();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		for (Client m : sel)   
		{       
		items.remove(m);    
	} 
	}
	
	
	public void RetourClient() {
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
