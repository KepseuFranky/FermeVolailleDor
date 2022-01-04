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

public class IncubationController {
	Connecter con = new Connecter();
	
	
	@FXML private TableView<Incubation> tableIncubation ;
	@FXML private TableColumn<Incubation, Integer> cidInc;
	@FXML private TableColumn<Incubation, Integer> cProduirePoussin_id; 
	@FXML private TableColumn<Incubation, Integer> ccollect_id;
	@FXML private TableColumn<Incubation, String> cdateInc;

	ObservableList<Incubation> dataIncubation = FXCollections.observableArrayList();
	
	
	
	@FXML private TextField idInc;
	@FXML private TextField ProduirePoussin_id;
	@FXML private TextField collect_id;
	@FXML private TextField dateInc;
	
	
	
	
	public void actualiser() {
		dataIncubation.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		dataIncubation.clear();
		String sql = "SELECT * FROM Incubation";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			dataIncubation.add(new Incubation(rs.getInt("idInc"),rs.getString("dateInc"),rs.getInt("ProduirePoussin_id"),rs.getInt("collect_id")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cidInc.setCellValueFactory(new PropertyValueFactory<Incubation, Integer>("idInc"));
		cProduirePoussin_id.setCellValueFactory(new PropertyValueFactory<Incubation, Integer>("ProduirePoussin_id"));
		ccollect_id.setCellValueFactory(new PropertyValueFactory<Incubation, Integer>("collect_id"));
		cdateInc.setCellValueFactory(new PropertyValueFactory<Incubation, String>("dateVac"));
		tableIncubation.setItems(dataIncubation);
        /*;*/
        /*}else {
        	
        }*/
	}
	
	
	
	
	public void ajouterbandeIncubation () /*throws IOException*/{
		
		
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
			
		
			
			
		String query="INSERT INTO Incubation(idInc,dateInc,ProduirePoussin_id,collect_id) values ("+Integer.parseInt(idInc.getText())+","+dateInc.getText()+","+Integer.parseInt(ProduirePoussin_id.getText())+","+Integer.parseInt(collect_id.getText())+")";
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
	
	
	
	public void NewIncubationaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("NewIncubation.fxml"));
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
		ObservableList<Incubation> sel;
		ObservableList<Incubation> items;   
		Incubation e = new Incubation();
	items = tableIncubation.getItems();
	sel = tableIncubation.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Incubation WHERE idInt = "+e.getIdInc();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		for (Incubation m : sel)   
		{       
		items.remove(m);    
	} 
	}
	
	
	public void RetourIncubation() {
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
