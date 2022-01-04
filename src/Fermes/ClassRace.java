package Fermes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassRace {
	private int idRace;
	private String nomRace;
	private String descriptionRace;
	private int prixRace;
	
	public int getIdRace() {
		return this.idRace;
	}
	
	public void setIdRace(int idRace) {
		this.idRace=idRace;
	}
	
	public IntegerProperty IdRace() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getIdRace());
    	return tel;
    }
	
	public String getNomRace() {
		return this.nomRace;
	}
	
	public void setNomRace(String nomRace) {
		this.nomRace=nomRace;
	}
	
	public StringProperty NomRace() {
    	final StringProperty nom=new SimpleStringProperty(this.getNomRace());
    	return nom;
    }
	
	public String getDescription() {
		return this.descriptionRace;
	}
	
	public void setDescription(String descriptionRace) {
		this.descriptionRace=descriptionRace;
	}
	
	public StringProperty DescriptionRace() {
    	final StringProperty nom=new SimpleStringProperty(this.getDescription());
    	return nom;
    }
	
	public int getPrixRace() {
		return this.prixRace;
	}
	
	public void setPrixRace(int prixRace) {
		this.prixRace=prixRace;
	}
	
	public IntegerProperty PrixRace() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getPrixRace());
    	return tel;
    }
}
