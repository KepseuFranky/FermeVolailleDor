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

public class VentesController {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<Vente> tableventes;
	@FXML private TableColumn<Vente, Integer> cidVente;
	@FXML private TableColumn<Vente, Integer> cbande_id;
	@FXML private TableColumn<Vente, Integer> cclient_id; 
	@FXML private TableColumn<Vente, String> cdateVente; 
	@FXML private TableColumn<Vente, Double> ctotal_prix; 
	@FXML private TableColumn<Vente, Integer> cqte;
	@FXML private TableColumn<Vente, Integer> cemploye_id;
	ObservableList<Vente> dataVente = FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idVente;
	@FXML private TextField bande_id;
	@FXML private TextField client_id;
	@FXML private TextField dateVente;
	@FXML private TextField total_prix;
	@FXML private TextField qte;
	@FXML private TextField employe_id;
	
	
	
	
	public void actualiser() {
		dataVente.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		dataVente.clear();
		String sql = "SELECT * FROM vendu";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			dataVente.add(new Vente(rs.getInt("idVente"),rs.getInt("client_id"),rs.getInt("bande_id"),rs.getString("dateVente"),rs.getDouble("total_prix"),rs.getInt("qte"),rs.getInt("employe_id")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidVente.setCellValueFactory(new PropertyValueFactory<Vente, Integer>("idVente"));
		cclient_id.setCellValueFactory(new PropertyValueFactory<Vente, Integer>("client_id"));
		cbande_id.setCellValueFactory(new PropertyValueFactory<Vente, Integer>("bande_id"));
		cdateVente.setCellValueFactory(new PropertyValueFactory<Vente, String>("dateVente"));
		ctotal_prix.setCellValueFactory(new PropertyValueFactory<Vente, Double>("total_prix"));
		cqte.setCellValueFactory(new PropertyValueFactory<Vente, Integer>("qte"));
		cemploye_id.setCellValueFactory(new PropertyValueFactory<Vente, Integer>("employe_id"));
		tableventes.setItems(dataVente);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterVente () /*throws IOException*/{
		
		
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
			
			
			
			
		String query="INSERT INTO Vendu(idVente,client_id,bande_id,dateVente,total_prix,qte,employe_id) values ("+Integer.parseInt(idVente.getText())+","+Integer.parseInt(client_id.getText())+","+Integer.parseInt(bande_id.getText())+","+dateVente.getText()+","+Double.parseDouble(total_prix.getText())+","+Integer.parseInt(qte.getText())+","+Integer.parseInt(employe_id.getText())+")";
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
	
	
	
	public void NewVentesaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("newVentes.fxml"));
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
		ObservableList<Vente> sel, items;   
		Vente e = new Vente();
	items = tableventes.getItems();  
	sel = tableventes.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Vendu WHERE idVente = "+e.getIdVente();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (Vente m : sel)   
	{        
		items.remove(m);    
	} 
	}
	
	
	public void RetourVentes() {
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
	

public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
