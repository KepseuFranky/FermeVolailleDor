package Fermes;

public class Utilisateur {
private String Nom;
private String Prenom;
private String Username;
private String Password;
private int grade;

public Utilisateur(String Nom, String Prenom, String Username, String Password,int grade) {
	this.Nom=Nom;
	this.Prenom=Prenom;
	this.Username=Username;
	this.Password=Password;
	this.grade=grade;
}

public Utilisateur() {
	this.Nom="";
	this.Prenom="";
	this.Username="";
	this.Password="";
	this.grade=2;
}

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}

public String getPrenom() {
	return Prenom;
}

public void setPrenom(String prenom) {
	Prenom = prenom;
}


public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}
}
