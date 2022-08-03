package dama.view;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dama.model.Damas;

public class NovaPartida extends JFrame implements ActionListener{

	private Label vermelhas,pretas,vs;
	
	private JButton boton1,boton2;
	
	private JComboBox<Object> combo1,combo2;
	
	private Principal principal;
	
	private PanelDeJogo panelDeJogo;
	
	public void iniciar() {
		
		boton1= new JButton("Comecar Partida");
		boton1.setBounds(50,70,140,30);
		boton1.addActionListener(this);
		
		boton2= new JButton("Sair");
		boton2.setBounds(220,70,100,30);
		boton2.addActionListener(this);
		
		vermelhas = new Label("vermelhas");
		vermelhas.setBounds(120,10,80,20);
		pretas = new Label("pretas");
		pretas.setBounds(230,10,50,20);
		vs = new Label("VS");
		vs.setBounds(185, 35, 30, 20);
		
		combo1 = new JComboBox<>();
		combo1.addItem("");
		combo1.addItem("Automatico");
		combo1.addItem("Manual");
		combo2 = new JComboBox<>();
		combo2.addItem("");
		combo2.addItem("Automatico");
		combo2.addItem("Manual");
		
		combo1.setBounds(100,35,70,20);
		combo2.setBounds(220,35,70,20);
	}
	
	public NovaPartida(Principal Pprincipal,PanelDeJogo jogo) {
		iniciar();
		principal = Pprincipal;
		panelDeJogo = jogo;
		setLayout(null);
		getContentPane().add(vermelhas);
		getContentPane().add(pretas);
		getContentPane().add(combo1);
		getContentPane().add(combo2);
		getContentPane().add(vs);
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		setResizable(false);
		setSize(400,150);
		setLocationRelativeTo(principal);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public NovaPartida() {
		
	}
	
	public void abrir() {
		
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			if(combo1.getSelectedIndex() == 0 || combo2.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(principal,"Os campos nao podem estar vazios");
			}else {
				principal.Actualizar_botones();
				panelDeJogo.trocar(combo1.getSelectedIndex(), combo2.getSelectedIndex());
				dispose();
			}
		}else {
			dispose();
		}
		
	}
}
