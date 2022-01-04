package Fermes;

public class ClassBande {

		private int quantite;
		private int age;
		private int idfournisseur;
		private int idbatiment;
		private int idrace;
		private double prixachat;
		private double prixvente;
		private String Datedemarrage;
		
		public ClassBande(int quantite, int age, int idfournisseur, int idbatiment, int idrace, double prixachat, double prixvente,String Datedemarrage) {
			this.quantite=quantite;
			this.age=age;
			this.idfournisseur=idfournisseur;
			this.idbatiment=idbatiment;
			this.idrace=idrace;
			this.prixachat=prixachat;
			this.prixvente=prixvente;
			this.Datedemarrage=Datedemarrage;
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


		
}
