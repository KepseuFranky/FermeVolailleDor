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

public class Bandemaladecontroller {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<Bandemalade> tablecontrolebandemalade ;
	@FXML private TableColumn<Bandemalade, Integer> cidBandeMalade;
	@FXML private TableColumn<Bandemalade, Integer> cmaladie_id; 
	@FXML private TableColumn<Bandemalade, Integer> cbande_id;
	@FXML private TableColumn<Bandemalade, Integer> cqteMalade; 
	@FXML private TableColumn<Bandemalade, Integer> cqtePrise; 
	@FXML private TableColumn<Bandemalade, String> cdateM;
	@FXML private TableColumn<Bandemalade, Integer> ctotalMort;
	ObservableList<Bandemalade> databandemalade = FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idBandeMalade;
	@FXML private TextField maladie_id;
	@FXML private TextField bande_id;
	@FXML private TextField qteMalade;
	@FXML private TextField qtePrise;
	@FXML private TextField dateM;
	@FXML private TextField prixachatcontrolebande;
	@FXML private TextField totalMort;
	
	
	
	
	public void actualiser() {
		databandemalade.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		databandemalade.clear();
		String sql = "SELECT * FROM bandemalade";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			databandemalade.add(new Bandemalade(rs.getInt("idBandeMalade"),rs.getInt("maladie_id"),rs.getInt("bande_id"),rs.getInt("qteMalade"),rs.getInt("qtePrise"),rs.getString("dateM"),rs.getInt("totalMort")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidBandeMalade.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("idBandeMalade"));
		cmaladie_id.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("maladie_id"));
		cbande_id.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("bande_id"));
		cqteMalade.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("qteMalade"));
		cqtePrise.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("qtePrise"));
		cdateM.setCellValueFactory(new PropertyValueFactory<Bandemalade, String>("dateM"));
		ctotalMort.setCellValueFactory(new PropertyValueFactory<Bandemalade, Integer>("totalMort"));
		tablecontrolebandemalade.setItems(databandemalade);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterbandemalade () /*throws IOException*/{
		
		
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
		String query="INSERT INTO Bandemalade(idBandeMalade,maladie_id,bande_id,qteMalade,qtePrise,dateM,totalMort) values ("+Integer.parseInt(idBandeMalade.getText())+","+Integer.parseInt(maladie_id.getText())+","+Integer.parseInt(bande_id.getText())+","+Integer.parseInt(qteMalade.getText())+","+Integer.parseInt(qtePrise.getText())+","+dateM.getText()+","+Integer.parseInt(totalMort.getText())+")";
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
	
	
	
	public void Newcontrolebandemaladeaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("newControlebandemalade.fxml"));
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
		ObservableList<Bandemalade> sel, items;   
		Bandemalade e = new Bandemalade();
	items = tablecontrolebandemalade.getItems();  
	sel = tablecontrolebandemalade.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Bandemalade WHERE idBandeMalade = "+e.getIdBandeMalade();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (Bandemalade m : sel)   
	{        
		items.remove(m);    
	} 
	}
	
	
	public void Retourbandemalade() {
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
