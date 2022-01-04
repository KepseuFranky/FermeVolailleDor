package Fermes;


public class Bandemalade {
private int idBandeMalade;
private int maladie_id;
private int bande_id;
private int qteMalade;
private int qtePrise;
private String dateM;
private int totalMort;

public Bandemalade(){
	idBandeMalade=0;
	maladie_id=0;
	bande_id=0;
	qteMalade=0;
	qtePrise=0;
	dateM="";
	totalMort=0;
}

public Bandemalade(int idBandeMalade,int maladie_id,int bande_id,int qteMalade,int qtePrise,String dateM,int totalMort){
	this.idBandeMalade=idBandeMalade;
	this.maladie_id=maladie_id;
	this.bande_id=bande_id;
	this.qteMalade=qteMalade;
	this.qtePrise=qtePrise;
	this.dateM=dateM;
	this.totalMort=totalMort;
}

public int getIdBandeMalade() {
	return idBandeMalade;
}

public void setIdBandeMalade(int idBandeMalade) {
	this.idBandeMalade = idBandeMalade;
}

public int getMaladie_id() {
	return maladie_id;
}

public void setMaladie_id(int maladie_id) {
	this.maladie_id = maladie_id;
}

public int getBande_id() {
	return bande_id;
}

public void setBande_id(int bande_id) {
	this.bande_id = bande_id;
}

public int getQteMalade() {
	return qteMalade;
}

public void setQteMalade(int qteMalade) {
	this.qteMalade = qteMalade;
}

public int getQtePrise() {
	return qtePrise;
}

public void setQtePrise(int qtePrise) {
	this.qtePrise = qtePrise;
}

public String getDateM() {
	return dateM;
}

public void setDateM(String dateM) {
	this.dateM = dateM;
}

public int getTotalMort() {
	return totalMort;
}

public void setTotalMort(int totalMort) {
	this.totalMort = totalMort;
}

}

