package dama.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dama.model.Damas;

@SuppressWarnings("serial")
public class PanelDeJogo extends JPanel implements ActionListener {

	private JButton boton[][];

	private Damas damas;

	private PanelImagen imagem;

	private NovaPartida sele;
	
	private int tamanho = 60, tabuleiro[][] = new int[8][8];
	
	public void iniciar() {
		
		imagem = new PanelImagen();
		boton = new JButton[8][8];
		damas = new Damas();
		damas.coloca_pecas();
		removeAll();
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {

				boton[i][j] = new JButton();
				boton[i][j].setBackground(Color.WHITE);
				boton[i][j].setBorderPainted(false);
				boton[i][j].setContentAreaFilled(false);
				boton[i][j].setOpaque(false);
				boton[i][j].addActionListener(this);
				boton[i][j].setIcon(new ImageIcon("./imagens/espacoBranco.png"));
			}
		}
	}

	public void ResetearTabuleiro() {
		damas.coloca_pecas();
	}
	
	public void destribui_tabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (j % 2 == 0) {
					tabuleiro[1][j] = 5;
					tabuleiro[7][j] = 5;
					tabuleiro[5][j] = 5;
					tabuleiro[3][j] = 5;
				} else {
					tabuleiro[0][j] = 5;
					tabuleiro[6][j] = 5;
					tabuleiro[2][j] = 5;
					tabuleiro[4][j] = 5;
				}
			}
		}
	}
	
	public void cria_tabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (tabuleiro[i][j] == damas.getPretas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/PeaoPreto.png"));
				} else if (tabuleiro[i][j] == damas.getVermelhas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/PeaoVermelha.png"));
				} else if (tabuleiro[i][j] == damas.getdamaV()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/DamaVermnelha.png"));
				} else if (tabuleiro[i][j] == damas.getdamaP()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/DamaPreto.png"));
				} else if (tabuleiro[i][j] == damas.getPreenchimento()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/espacoPreto.png"));
				}
			}
		}
	}
	
	public void destribuirbotoes() {
		damas.verificar(damas.getColor());
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (damas.verdamas(i, j) == damas.getPretas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/PeaoPreto.png"));
				} else if (damas.verdamas(i, j) == damas.getVermelhas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/PeaoVermelha.png"));
				} else if (damas.verdamas(i, j) == damas.getdamaV()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/DamaVermnelha.png"));
				} else if (damas.verdamas(i, j) == damas.getdamaP()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/DamaPreto.png"));
				} else if (damas.verdamas(i, j) == damas.getPreenchimento()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/espacoPreto.png"));
				}
			}
		}
	}

	public void alo() {
		damas.coloca_pecas();
		destribuirbotoes();
	}

	public boolean IA(boolean pasa) {
		int x = (int) (Math.random() * 8) + 0;
		int y = (int) (Math.random() * 8) + 0;
		int x1 = (int) (Math.random() * 8) + 0;
		int y1 = (int) (Math.random() * 8) + 0;
		if (damas.jogar(damas.getColor(), x, y, x1, y1) == true) {
			destribuirbotoes();
			boton[x][y].setIcon(new ImageIcon("./imagens/espacoPreto.png"));
			return true;
		}
		return pasa;
	}

	public void alinear() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {
				panel.add(boton[i][j]);
			}
		}
		add(panel);
	}

	public PanelDeJogo() {
		sele = new NovaPartida();
		iniciar();
		setLayout(new BorderLayout());
		//setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("juego")));
		setVisible(true);
		alinear();
		destribui_tabuleiro();
		cria_tabuleiro();
	}

	public void trocar(int vermelhas,int pretas) {
		this.vermelhas = vermelhas;
		this.pretas = pretas;
	}
	
	int contar = 0;
	int x = 0, y = 0, x1 = 0, y1 = 0,vermelhas,pretas;

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean pasa = false;
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {
				if(e.getSource() == boton[i][j]) {
					
					if(vermelhas == 1 && pretas == 1) {
						//Rojas:Automatico Vs Negras:Automatico
						
						while(IA(pasa) == false) {
							
						}
						damas.MudaDeTurno();
					}else if(vermelhas == 2 && pretas == 2) {
						//Rojas:Manual Vs Negras:Manual
						if(damas.verificar_exitencia_de_peca(damas.getColor(), i, j)) {
							x = i;
							y = j;
							contar++;
						}else if(contar == 1) {
							if(damas.jogar(damas.getColor(), x, y, i, j)) {
								destribuirbotoes();
								damas.MudaDeTurno();
							}else {
								JOptionPane.showMessageDialog(null,"Movimento Invalido");
							}
							contar--;
						}
					}else if(vermelhas == 1 && pretas == 2) {
						//Rojas:Automatico Vs Negras:Manual
						
						if(damas.getColor() == 'N') {
							if(damas.verificar_exitencia_de_peca(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jogar(damas.getColor(), x, y, i, j)) {
									destribuirbotoes();
									damas.MudaDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.MudaDeTurno();
						}
						
						
					}else if(vermelhas == 2 && pretas == 1) {
						//Rojas:Manual Vs Negras:Automatico
						
						if(damas.getColor() == 'R') {
							if(damas.verificar_exitencia_de_peca(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jogar(damas.getColor(), x, y, i, j)) {
									destribuirbotoes();
									damas.MudaDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.MudaDeTurno();
						}
						
					}
				}
			}
		}
	}
}
