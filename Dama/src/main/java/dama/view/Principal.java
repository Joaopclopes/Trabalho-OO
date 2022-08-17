package dama.view;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame{
	
	Painel_de_Jogo jogo;
	
	BarraFerramentas panel1;
	
	Painel_Imagem imagem;
	
	public Principal() {
		super("Damas");
		iniciar();
		alinhar();
		setVisible(true);
		setResizable(false);
		setSize(685,531);
		setSize(480,520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void alinhar() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Informacao")));
		panel.add(imagem);
		
		setLayout(new BorderLayout());
		add(jogo, BorderLayout.CENTER);
		add(panel1, BorderLayout.NORTH);
		add(panel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) 
        {
            new Principal();
	}
	
	public void Atualizar_Botoes() {
		jogo.ResetaTabuleiro();
		jogo.destribuirbotoes();
	}
	
	public void iniciar() {
		jogo = new Painel_de_Jogo();
		panel1 = new BarraFerramentas(this,jogo);
		imagem = new Painel_Imagem();
	}
}
