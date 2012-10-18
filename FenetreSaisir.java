
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class FenetreSaisir extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField saisirNum;
	private JTextField saisirNom;
	private JTextField saisirPrenom;
	private JButton valid;
	
	public FenetreSaisir(){
		panel = new JPanel();
		saisirNum = new JTextField ("Numero du pilote ");
		saisirNom = new JTextField ("Nom du pilote ");
		saisirPrenom = new JTextField ("Prenom du pilote ");
		valid = new JButton("Envoyer");
		
		this.setTitle("Pilote");
		this.setLocation(430,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setUndecorated(false);
		//this.setVisible(true);

		this.getContentPane().add(panel);
		
		panel.setLayout(new FlowLayout());
		panel.add(saisirNum);
		panel.add(saisirNom);
		panel.add(saisirPrenom);
		panel.add(valid);
		valid.addActionListener(this);
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent a) {
		int num = Integer.parseInt(saisirNum.getText());
		String nom = saisirNom.getText();
		String prenom = saisirPrenom.getText();
		
		Connection co = null;
		
		try { 

			Class.forName("org.postgresql.Driver") ;
			co = DriverManager.getConnection("jdbc:postgresql:bddorville", "mdorville", "kugipanchi");
		    //TODO
			Statement stInsert = co.createStatement();
			stInsert.executeUpdate("INSERT INTO Pilotes(numPilote, nomPilote, prenomPilote)" +
					"VALUES('"+num+"','"+nom+"','"+prenom+"');");
			
			co.close();
		} 
		catch(ClassNotFoundException erreur) { 
			System.out.println("Driver non chargé !"+erreur); 
		} 
		catch(SQLException erreur) { 
			System.out.println("SQL error"+erreur);
		} 

	}
}
