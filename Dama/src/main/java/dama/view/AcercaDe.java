package dama.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AcercaDe extends JFrame {

	private Principal principal;
	
	private JLabel label1,label2,label3;
	
	private JTextArea area;
	
	private JScrollPane panel;
	
	private Hiperlink label4,label5;
	
	public AcercaDe(Principal Pprincipal) {
		principal = Pprincipal;
		iniciar();
		alinhar();
		setSize(500,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(principal);
	}
	
	public void alinhar() {
		setLayout(null);
		label1.setBounds(160,0,500,50);
		getContentPane().add(label1);
		label2.setBounds(0,250,500,50);
		getContentPane().add(label2);
		label3.setBounds(150,250,500,50);
		getContentPane().add(label3);
		label4.setBounds(220,265,500,20);
		getContentPane().add(label4);
		label5.setBounds(220,285,500,20);
		getContentPane().add(label5);
		panel.setBounds(0,50,485,200);
		getContentPane().add(panel);
	}
	
	public void iniciar() {
		label1 = new JLabel("Jogo De Damas");
		label1.setFont(new Font("1942 report", Font.CENTER_BASELINE, 18));
		label2 = new JLabel("Version 2.2");
		label2.setFont(new Font("1942 report", Font.CENTER_BASELINE, 13));
		label3 = new JLabel("fontes:");
		label2.setFont(new Font("1942 report", Font.CENTER_BASELINE, 13));
		area = new JTextArea();
		area.setEditable(false);
		panel = new JScrollPane(area);
	}
	
}
