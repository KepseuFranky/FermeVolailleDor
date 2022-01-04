package Fermes;

public class VenteOeuf {
private int idVente;
private int client_id;
private int collect_id;
private String dateVente;
private double total_prix;
private double qte;
private int employe_id;

public VenteOeuf() {
	idVente=0;
	client_id=0;
	collect_id=0;
	dateVente="";
	total_prix=0;
	qte=0;
	employe_id=0;
}

public VenteOeuf(int idVente, int client_id, int collect_id,String dateVente, double total_prix, int qte, int employe_id) {
	this.idVente=idVente;
	this.client_id=client_id;
	this.collect_id=collect_id;
	this.dateVente=dateVente;
	this.total_prix=total_prix;
	this.qte=qte;
	this.employe_id=employe_id;
}

public int getIdVente() {
	return idVente;
}

public void setIdVente(int idVente) {
	this.idVente = idVente;
}

public int getClient_id() {
	return client_id;
}

public void setClient_id(int client_id) {
	this.client_id = client_id;
}

public int getCollect_id() {
	return collect_id;
}

public void setBande_id(int bande_id) {
	this.collect_id = bande_id;
}

public String getDateVente() {
	return dateVente;
}

public void setDateVente(String dateVente) {
	this.dateVente = dateVente;
}

public double getTotal_prix() {
	return total_prix;
}

public void setTotal_prix(double total_prix) {
	this.total_prix = total_prix;
}

public double getQte() {
	return qte;
}

public void setQte(double qte) {
	this.qte = qte;
}

public int getEmploye_id() {
	return employe_id;
}

public void setEmploye_id(int employe_id) {
	this.employe_id = employe_id;
}

}
