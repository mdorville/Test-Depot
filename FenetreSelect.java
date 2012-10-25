import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class FenetreSelect extends JFrame{	
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;

	public FenetreSelect(){
		panel = new JPanel();
		
		this.setTitle("Table Pilote");
		this.setLocation(430,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setUndecorated(false);
		this.getContentPane().add(panel);
		
		Connection co = null;
		try { 

			Class.forName("org.postgresql.Driver") ;
			co = DriverManager.getConnection("jdbc:postgresql:bddorville", "mdorville", "kugipanchi");
			Statement stSelect = co.createStatement();
			ResultSet rsSelect = stSelect.executeQuery("SELECT * FROM Pilotes");
			while (rsSelect.next()) {
			int num = rsSelect.getInt("numPilote");
			String nom = rsSelect.getString(2);
			String prenom = rsSelect.getString(3);
			label1 = new JLabel("Numero : "+num+" Nom : "+nom+" Prenom : "+prenom);
			panel.setLayout(new GridLayout(rsSelect.getFetchSize(),1));
			panel.add(label1);
			}
			co.close();
		}
		catch(ClassNotFoundException erreur) { 
			System.out.println("Driver non chargé !"+erreur); 
		} 
		catch(SQLException erreur) { 
			System.out.println("SQL error"+erreur);
		}
		

		
		this.setVisible(true);
	}
	
}
