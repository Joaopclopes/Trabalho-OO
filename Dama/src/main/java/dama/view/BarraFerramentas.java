package dama.view;

import java.awt.BorderLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class BarraFerramentas extends JPanel implements ActionListener{

	private JMenu menu;
	
	private JMenu menu1;
	
	private JMenuBar barra;
	
	private JMenuItem novapartida,sair,Sobre,trocar_modo;
	
	private Principal principal;
	
	private Painel_de_Jogo panelDeJogo;
	
	private void iniciar() {
		novapartida = new JMenuItem("Nova partida");
		trocar_modo = new JMenuItem("trocar Modo");
		sair = new JMenuItem("Sair");
		Sobre = new JMenuItem("Sobre de...");
		menu = new JMenu("Arquivo");
		menu1 = new JMenu("Ajuda");
		menu.add(novapartida);
		
		menu.add(trocar_modo);
		menu.add(sair);
		trocar_modo.addActionListener(this);
		novapartida.addActionListener(this);
		sair.addActionListener(this);
		
		barra = new JMenuBar();
		barra.add(menu);
		
	}
	
	private void alinear() {
		setLayout(new BorderLayout());
		add(barra,BorderLayout.CENTER);
	}
	
	public BarraFerramentas(Principal Pprincipal,Painel_de_Jogo jogo) {
		iniciar();
		alinear();
		panelDeJogo = jogo;
		principal = Pprincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == novapartida) {
			new NovaPartida(principal,panelDeJogo).abrir();
		}
		if(e.getSource() == sair) {
			principal.dispose();
		}
		
		if(e.getSource() == trocar_modo) {
			new Selecao_de_Modo(principal,panelDeJogo).abrir();
		}
	}
}
