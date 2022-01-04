package Fermes;

import fermePOO.control.MainApp;
import fermePOO.model.ClassVaccin;
import fermePOO.model.ClassVaccin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class VaccinOverviewController {
	@FXML
    private TableView<ClassVaccin> vaccinTable;
 	@FXML
    private TableColumn<ClassVaccin, Integer> idVaccin;
    @FXML
    private TableColumn<ClassVaccin, String> nomVaccin;
    @FXML
    private TableColumn<ClassVaccin, String> periodeVaccin;
    @FXML
    private TableColumn<ClassVaccin, Integer> quantiteVaccin;
    @FXML
    private TableColumn<ClassVaccin, Integer> quantitePoule;
    @FXML
    private TableColumn<ClassVaccin, Integer> prixVaccin;
    @FXML
    private TableColumn<ClassVaccin, String > descriptionVaccin;
	private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public VaccinOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	idVaccin.setCellValueFactory(cellData -> cellData.getValue().IdVaccin().asObject());
        nomVaccin.setCellValueFactory(cellData -> cellData.getValue().NomVaccin());
        periodeVaccin.setCellValueFactory(cellData -> cellData.getValue().PeriodeVaccin());
        quantiteVaccin.setCellValueFactory(cellData -> cellData.getValue().QteVaccin().asObject());
        quantitePoule.setCellValueFactory(cellData -> cellData.getValue().QtePoule().asObject());
        prixVaccin.setCellValueFactory(cellData -> cellData.getValue().PrixVaccin().asObject());
        descriptionVaccin.setCellValueFactory(cellData -> cellData.getValue().DescriptionVaccin());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        vaccinTable.setItems(mainApp.getVaccinData());
    }
    
    
    
    
    
    @FXML
    private void handleDeleteVaccin() {
        int selectedIndex = vaccinTable.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
        	//ClassMethodeSQL.DeletevaccinSQL( vaccinTable.getSelectionModel().getSelectedItem());
        	vaccinTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Material Selected");
            alert.setContentText("Please select a material in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewVaccin() {
        ClassVaccin tempVaccin = new ClassVaccin();
        boolean okClicked = mainApp.showVaccinEditDialog(tempVaccin);
        
        
        if (okClicked) {
        	mainApp.getVaccinData().add(tempVaccin);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditVaccin() {
        ClassVaccin selectedVaccin = vaccinTable.getSelectionModel().getSelectedItem();
        if (selectedVaccin != null) {
            boolean okClicked = mainApp.showVaccinEditDialog(selectedVaccin);
            

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Vaccin Selected");
            alert.setContentText("Please select a Vaccin in the table.");

            alert.showAndWait();
        }
    }
    @FXML
    private void handleRetourVaccin() {
    	//mainApp.showPannelChoiceOverview();
    }
}
