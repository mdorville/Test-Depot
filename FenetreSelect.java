import java.awt.GridLayout;
import javax.swing.*;



public class FenetreSelect extends JFrame{	
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;

	public FenetreSelect(){
		panel = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		
		this.setTitle("Table Pilote");
		this.setLocation(430,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setUndecorated(false);
		this.getContentPane().add(panel);
		
		panel.setLayout(new GridLayout());
		
		this.setVisible(true);
	}
	
}
