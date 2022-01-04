package Fermes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassVaccin {
	private int idVaccin;
	private String nomVaccin;
	private String periodeVaccin;
	private int qteVaccin;
	private int qtePoule;
	private String descriptionVaccin;
	private int prixVaccin;
	
	public int getIdVaccin() {
		return this.idVaccin;
	}
	
	public void setIdVaccin(int idVaccin) {
		this.idVaccin=idVaccin;
	}
	
	public IntegerProperty IdVaccin() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getIdVaccin());
    	return tel;
    }
	
	public String getNomVaccin() {
		return this.nomVaccin;
	}
	
	public void setNomVaccin(String nomVaccin) {
		this.nomVaccin=nomVaccin;
	}
	
	public StringProperty NomVaccin() {
    	final StringProperty nom=new SimpleStringProperty(this.getNomVaccin());
    	return nom;
    }
	
	public String getPeriodeVaccin() {
		return this.periodeVaccin;
	}
	
	public void setPeriodeVaccin(String periodeVaccin) {
		this.periodeVaccin=periodeVaccin;
	}
	
	public StringProperty PeriodeVaccin() {
    	final StringProperty nom=new SimpleStringProperty(this.getPeriodeVaccin());
    	return nom;
    }
	
	public int getQteVaccin() {
		return this.qteVaccin;
	}
	
	public void setQteVaccin(int qteVaccin) {
		this.qteVaccin=qteVaccin;
	}
	
	public IntegerProperty QteVaccin() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getQteVaccin());
    	return tel;
    }
	
	public int getQtePoule() {
		return this.qtePoule;
	}
	
	public void setQtePoule(int qtePoule) {
		this.qtePoule=qtePoule;
	}
	public IntegerProperty QtePoule() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getQtePoule());
    	return tel;
    }
	
	public String getDescription() {
		return this.descriptionVaccin;
	}
	
	public void setDescription(String descriptionVaccin) {
		this.descriptionVaccin=descriptionVaccin;
	}
	
	public StringProperty DescriptionVaccin() {
    	final StringProperty nom=new SimpleStringProperty(this.getDescription());
    	return nom;
    }
	
	public int getPrixVaccin() {
		return this.prixVaccin;
	}
	
	public void setPrixVaccin(int prixVaccin) {
		this.prixVaccin=prixVaccin;
	}
	
	public IntegerProperty PrixVaccin() {
    	final IntegerProperty tel=new SimpleIntegerProperty(this.getPrixVaccin());
    	return tel;
    }

	
}
