
import java.sql.*;

public class AfficherSelect {
	
	public void afficher(){
		
		Connection co = null;
		
		try { 

			Class.forName("org.postgresql.Driver") ;
			co = DriverManager.getConnection("jdbc:postgresql:bddorville", "mdorville", "kugipanchi");
		    //TODO
			Statement stSelect = co.createStatement();
			ResultSet rsSelect = stSelect.executeQuery("SELECT * FROM Pilotes");
			while (rsSelect.next()) {
			int num = rsSelect.getInt("numPilote");
			String nom = rsSelect.getString(2);
			String prenom = rsSelect.getString(3);
			System.out.println("Numero : "+num+" Nom : "+nom+" Prenom : "+prenom) ;
			}
			co.close();
		}
		catch(ClassNotFoundException erreur) { 
			System.out.println("Driver non charg� !"+erreur); 
		} 
		catch(SQLException erreur) { 
			System.out.println("SQL error"+erreur);
		} 

	}
}
