package dama.view;

import java.awt.BorderLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class PanelBarraDeFerramentas extends JPanel implements ActionListener{

	private JMenu menu;
	
	private JMenu menu1;
	
	private JMenuBar barra;
	
	private JMenuItem novapartida,sair,Sobre,trocar_modo;
	
	private Principal principal;
	
	private PanelDeJogo panelDeJogo;
	
	private void iniciar() {
		novapartida = new JMenuItem("Nova partida");
		trocar_modo = new JMenuItem("trocar Modo");
		sair = new JMenuItem("Sair");
		Sobre = new JMenuItem("Sobre de...");
		menu = new JMenu("Aquivo");
		menu1 = new JMenu("Ajuda");
		menu.add(novapartida);
		menu1.add(Sobre);
		menu.add(trocar_modo);
		menu.add(sair);
		trocar_modo.addActionListener(this);
		novapartida.addActionListener(this);
		sair.addActionListener(this);
		Sobre.addActionListener(this);
		barra = new JMenuBar();
		barra.add(menu);
		barra.add(menu1);
	}
	
	private void alinear() {
		setLayout(new BorderLayout());
		add(barra,BorderLayout.CENTER);
	}
	
	public PanelBarraDeFerramentas(Principal Pprincipal,PanelDeJogo jogo) {
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
		if(e.getSource() == Sobre) {
			new AcercaDe(principal);
		}
		if(e.getSource() == trocar_modo) {
			new selecao_de_modo(principal,panelDeJogo).abrir();;
		}
	}
}
