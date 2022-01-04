package Fermes;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

	   public static void createNewDatabase(String BDdechet) {
		   
	        String url = "C:Users/PC/Documents/kepseu/java eclipse/Gestion-Dechets/BD/" + BDdechet;
	
	        try (Connection conn = DriverManager.getConnection(url)) {
	            if (conn != null) {
	                DatabaseMetaData meta = conn.getMetaData();
	                System.out.println("The driver name is " + meta.getDriverName());
	                System.out.println("A new database has been created.");
	            }
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	   }
	        
	       
	        public static void main(String[] args) {
	            createNewDatabase("test.db");
	        }
}	   
