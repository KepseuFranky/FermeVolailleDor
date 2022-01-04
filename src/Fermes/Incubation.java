package Fermes;

public class Incubation {
private int idInc; 
private String dateInc; 
private int ProduirePoussin_id;
private int collect_id;


public Incubation(int idInc, String dateInc, int ProduirePoussin_id, int collect_id) {
	this.idInc=idInc;
	this.dateInc=dateInc;
	this.ProduirePoussin_id=ProduirePoussin_id;
	this.collect_id=collect_id;
}

public Incubation() {
	this.idInc=0;
	this.dateInc="";
	this.ProduirePoussin_id=0;
	this.collect_id=0;
}

public int getIdInc() {
	return idInc;
}

public void setIdInc(int idInc) {
	this.idInc = idInc;
}

public String getDateInc() {
	return dateInc;
}

public void setDateInc(String dateInc) {
	this.dateInc = dateInc;
}

public int getProduirePoussin_id() {
	return ProduirePoussin_id;
}

public void setProduirePoussin_id(int produirePoussin_id) {
	ProduirePoussin_id = produirePoussin_id;
}

public int getCollect_id() {
	return collect_id;
}

public void setCollect_id(int collect_id) {
	this.collect_id = collect_id;
}



}

