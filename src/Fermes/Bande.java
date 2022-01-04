package Fermes;

public class Bande {
	private int idbande;	
private int quantite;
private int age;
private int idfournisseur;
private int idbatiment;
private int idrace;
private double prixachat;
private double prixvente;
private String Datedemarrage;
public Bande(int idbande,int quantite, int age, int idfournisseur, int idbatiment, int idrace, double prixachat, double prixvente,String Datedemarrage) {
	this.idbande=idbande;
	this.quantite=quantite;
	this.age=age;
	this.idfournisseur=idfournisseur;
	this.idbatiment=idbatiment;
	this.idrace=idrace;
	this.prixachat=prixachat;
	this.prixvente=prixvente;
	this.Datedemarrage=Datedemarrage;
}

public Bande() {
	this.idbande=0;
	this.quantite=0;
	this.age=0;
	this.idfournisseur=0;
	this.idbatiment=0;
	this.idrace=0;
	this.prixachat=0;
	this.prixvente=0;
	this.Datedemarrage="";
}

public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getIdfournisseur() {
	return idfournisseur;
}
public void setIdfournisseur(int idfournisseur) {
	this.idfournisseur = idfournisseur;
}
public int getIdbatiment() {
	return idbatiment;
}
public void setIdbatiment(int idbatiment) {
	this.idbatiment = idbatiment;
}
public int getIdrace() {
	return idrace;
}
public void setIdrace(int idrace) {
	this.idrace = idrace;
}
public double getPrixachat() {
	return prixachat;
}
public void setPrixachat(double prixachat) {
	this.prixachat = prixachat;
}
public double getPrixvente() {
	return prixvente;
}
public void setPrixvente(double prixvente) {
	this.prixvente = prixvente;
}
public String getDatedemarrage() {
	return Datedemarrage;
}
public void setDatedemarrage(String datedemarrage) {
	Datedemarrage = datedemarrage;
}
public int getIdbande() {
	return idbande;
}
public void setIdbande(int idbande) {
	this.idbande = idbande;
}


}
