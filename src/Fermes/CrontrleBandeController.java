package Fermes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CrontrleBandeController {
	@FXML private TableView<Bande> tablecontrolebande ;
	@FXML private TableColumn<Bande, Integer> idbandecontrolebande;
	@FXML private TableColumn<Bande, Integer> cquantitecontrolebande; 
	@FXML private TableColumn<Bande, Integer> cAgecontrolebande;
	@FXML private TableColumn<Bande, Integer> cidfournisseurcontrolebande; 
	@FXML private TableColumn<Bande, Integer> cidBatimentcontrolebande; 
	@FXML private TableColumn<Bande, Integer> cidracecontrolebande;
	@FXML private TableColumn<Bande, Double> cprixventecontrolebandec;
	@FXML private TableColumn<Bande, Double> cprixachatcontrolebandec;
	@FXML private TableColumn<Bande, String> cDatedemarragecontrolebande;
	ObservableList<Bande> datacontrolebande = FXCollections.observableArrayList();
	Connecter con = new Connecter();
   
	@FXML private TextField quantitecontrolebande;
	@FXML private TextField Agecontrolebande;
	@FXML private TextField Idfournisseurcontrolebande;
	@FXML private TextField idbatimentcontrolebande;
	@FXML private TextField idracecontrolebande;
	@FXML private TextField prixventecontrolebande;
	@FXML private TextField prixachatcontrolebande;
	@FXML private TextField Datedemarragecontrolebande;
	
	
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
	
	
	
	public void actualiser() {
		datacontrolebande.clear();
	    /*if(i==0) {*/
		try {
		con.obtenirconnexion();
		datacontrolebande.clear();
		String sql = "SELECT * FROM bande";
		PreparedStatement stat = con.obtenirconnexion().prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			datacontrolebande.add(new Bande(rs.getInt("idBande"),rs.getInt("qte"),rs.getInt("age"),rs.getInt("fourn_id"),rs.getInt("bat_id"),rs.getInt("race_id"),rs.getDouble("prix_achat"),rs.getDouble("prix_vente"),rs.getString("dateDemarrage")));
			
		}
		/*con.obtenirconnexion().close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		idbandecontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("idbande"));
		cquantitecontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("quantite"));
		cAgecontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("age"));
		cidfournisseurcontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("idfournisseur"));
		cidBatimentcontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("idbatiment"));
		cidracecontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, Integer>("idrace"));
		cprixventecontrolebandec.setCellValueFactory(new PropertyValueFactory<Bande, Double>("prixachat"));
		cprixventecontrolebandec.setCellValueFactory(new PropertyValueFactory<Bande, Double>("prixvente"));
		cDatedemarragecontrolebande.setCellValueFactory(new PropertyValueFactory<Bande, String>("Datedemarrage"));
		
		tablecontrolebande.setItems(datacontrolebande);
		
	}
		
	
	public void ajoutercontrolebande () /*throws IOException*/{
		
		
		try {
		actualiser();
			int i=0;
           
		String query="INSERT INTO Bande(qte,Age,race_id,prix_achat,prix_vente,dateDemarrage,fourn_id,bat_id) values ("+Integer.parseInt(quantitecontrolebande.getText())+","+Integer.parseInt(Agecontrolebande.getText())+","+Integer.parseInt(idracecontrolebande.getText())+","+Double.parseDouble(prixachatcontrolebande.getText())+","+Double.parseDouble(prixventecontrolebande.getText())+","+Datedemarragecontrolebande.getText()+","+Integer.parseInt(Idfournisseurcontrolebande.getText())+","+Integer.parseInt(idbatimentcontrolebande.getText())+")";
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
			transmission2.executeUpdate(query);
           } catch (SQLException e) {
			// TODO Auto-generated catch block
	            e.printStackTrace();
		}
	}
	
	
	
	public void supprimer() {   
		ObservableList<Bande> sel, items;   
		Bande e = new Bande();
	items = tablecontrolebande.getItems();  
	sel = tablecontrolebande.getSelectionModel().getSelectedItems();    
	e=sel.get(0);
		try {
		Statement transmission2=null;
		transmission2=con.obtenirconnexion().createStatement();
	String query2="DELETE FROM Bande WHERE idBande = "+e.getIdbande();
		transmission2.executeUpdate(query2);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (Bande m : sel)   
	{        
		items.remove(m);    
	} 
	}
	
	
	public void Newcontrolebandeaction() {
		Parent tableViewParent;
		try {
			Stage primarystage = new Stage();
			tableViewParent = FXMLLoader.load(this.getClass().getResource("newControlebande.fxml"));
			Scene scene1 = new Scene(tableViewParent);
			primarystage.setScene(scene1);
			primarystage.show();
			/*BienvenueController.bienvenue.setText("BIENVENUE "+useractuel.getUsername()+" !!!");*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
