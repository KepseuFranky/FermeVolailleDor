package Fermes;

public class Client {
private int idClient;
private String adresse;
private int tel;

public Client() {
	idClient=0;
	adresse="";
	tel=0;
}

public Client (int idClient, String adresse, int tel) {
	this.idClient=idClient;
	this.adresse=adresse;
	this.tel=tel;
}

public int getIdClient() {
	return idClient;
}

public void setIdClient(int idClient) {
	this.idClient = idClient;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public int getTel() {
	return tel;
}

public void setTel(int tel) {
	this.tel = tel;
}
}
