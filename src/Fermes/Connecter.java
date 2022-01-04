package Fermes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecter {
Connection con;
public Connecter() {
	try {
		Class.forName("com.mysql.jdbc.Driver");	
	}catch(ClassNotFoundException e) {
		System.err.println(e);
		// pour afficher l'erreur
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ferme_vollaile_d_or?characterEncoding=utf8","root","17102000");	
		}catch(SQLException e){
			e.printStackTrace();
		}
}
Connection obtenirconnexion() {
	return con;
}
}