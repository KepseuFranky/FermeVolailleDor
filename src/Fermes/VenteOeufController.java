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

public class VenteOeufController {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<VenteOeuf> tableventeoeuf;
	@FXML private TableColumn<VenteOeuf, Integer> cidVente;
	@FXML private TableColumn<VenteOeuf, Integer> ccollect_id;
	@FXML private TableColumn<VenteOeuf, Integer> cclient_id; 
	@FXML private TableColumn<VenteOeuf, String> cdateVente; 
	@FXML private TableColumn<VenteOeuf, Double> ctotal_prix; 
	@FXML private TableColumn<VenteOeuf, Integer> cqte;
	@FXML private TableColumn<VenteOeuf, Integer> cemploye_id;
	ObservableList<VenteOeuf> dataVente = FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idVente;
	@FXML private TextField collect_id;
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
			dataVente.add(new VenteOeuf(rs.getInt("idVente"),rs.getInt("collect_id"),rs.getInt("client_id"),rs.getString("dateVente"),rs.getDouble("total_prix"),rs.getInt("qte"),rs.getInt("employe_id")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidVente.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Integer>("idVente"));
		cclient_id.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Integer>("client_id"));
		ccollect_id.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Integer>("bande_id"));
		cdateVente.setCellValueFactory(new PropertyValueFactory<VenteOeuf, String>("dateVente"));
		ctotal_prix.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Double>("total_prix"));
		cqte.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Integer>("qte"));
		cemploye_id.setCellValueFactory(new PropertyValueFactory<VenteOeuf, Integer>("employe_id"));
		tableventeoeuf.setItems(dataVente);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterVenteoeuf () /*throws IOException*/{
		
		
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
			
			
			
			
		String query="INSERT INTO VenduOeuf(idVente,client_id,collect_id,dateVente,total_prix,qte,employe_id) values ("+Integer.parseInt(idVente.getText())+","+Integer.parseInt(client_id.getText())+","+Integer.parseInt(collect_id.getText())+","+dateVente.getText()+","+Double.parseDouble(total_prix.getText())+","+Integer.parseInt(qte.getText())+","+Integer.parseInt(employe_id.getText())+")";
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
	
	
	
	public void NewVenteoeufaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("NewVenteOeuf.fxml"));
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
		ObservableList<VenteOeuf> sel, items;   
		VenteOeuf e = new VenteOeuf();
	items = tableventeoeuf.getItems();  
	sel = tableventeoeuf.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Venduoeuf WHERE idVenteoeuf = "+e.getIdVente();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (VenteOeuf m : sel)   
	{        
		items.remove(m);    
	} 
	}
	
	
	public void RetourVenteoeuf() {
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
