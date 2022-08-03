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
	
	private int tamanho = 60, tablero[][] = new int[8][8];
	
	public void iniciar() {
		
		imagem = new PanelImagen();
		boton = new JButton[8][8];
		damas = new Damas();
		damas.poner_fichas();
		removeAll();
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {

				boton[i][j] = new JButton();
				boton[i][j].setBackground(Color.WHITE);
				boton[i][j].setBorderPainted(false);
				boton[i][j].setContentAreaFilled(false);
				boton[i][j].setOpaque(false);
				boton[i][j].addActionListener(this);
				boton[i][j].setIcon(new ImageIcon("./imagens/EspacionBlanco.png"));
			}
		}
	}

	public void ResetearTablero() {
		damas.poner_fichas();
	}
	
	public void dibujar_tablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (j % 2 == 0) {
					tablero[1][j] = 5;
					tablero[7][j] = 5;
					tablero[5][j] = 5;
					tablero[3][j] = 5;
				} else {
					tablero[0][j] = 5;
					tablero[6][j] = 5;
					tablero[2][j] = 5;
					tablero[4][j] = 5;
				}
			}
		}
	}
	
	public void crear_tabero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (tablero[i][j] == damas.getNegras()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaNn.jpg"));
				} else if (tablero[i][j] == damas.getRojas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRn.jpg"));
				} else if (tablero[i][j] == damas.getReinaR()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRRn.jpg"));
				} else if (tablero[i][j] == damas.getReinaN()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRNn.jpg"));
				} else if (tablero[i][j] == damas.getRelleno()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/EspacionNegro.png"));
				}
			}
		}
	}
	
	public void dibujar_en_los_botones() {
		damas.verificar(damas.getColor());
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (damas.verdamas(i, j) == damas.getNegras()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaNn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getRojas()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getReinaR()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRRn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getReinaN()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/fichaRNn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getRelleno()) {
					boton[i][j].setIcon(new ImageIcon("./imagens/EspacionNegro.png"));
				}
			}
		}
	}

	public void alo() {
		damas.poner_fichas();
		dibujar_en_los_botones();
	}

	public boolean IA(boolean pasa) {
		int x = (int) (Math.random() * 8) + 0;
		int y = (int) (Math.random() * 8) + 0;
		int x1 = (int) (Math.random() * 8) + 0;
		int y1 = (int) (Math.random() * 8) + 0;
		if (damas.jugar(damas.getColor(), x, y, x1, y1) == true) {
			dibujar_en_los_botones();
			boton[x][y].setIcon(new ImageIcon("./imagens/EspacionNegro.png"));
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
		dibujar_tablero();
		crear_tabero();
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
						damas.CambioDeTurno();
					}else if(vermelhas == 2 && pretas == 2) {
						//Rojas:Manual Vs Negras:Manual
						if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
							x = i;
							y = j;
							contar++;
						}else if(contar == 1) {
							if(damas.jugar(damas.getColor(), x, y, i, j)) {
								dibujar_en_los_botones();
								damas.CambioDeTurno();
							}else {
								JOptionPane.showMessageDialog(null,"Movimento Invalido");
							}
							contar--;
						}
					}else if(vermelhas == 1 && pretas == 2) {
						//Rojas:Automatico Vs Negras:Manual
						
						if(damas.getColor() == 'N') {
							if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jugar(damas.getColor(), x, y, i, j)) {
									dibujar_en_los_botones();
									damas.CambioDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.CambioDeTurno();
						}
						
						
					}else if(vermelhas == 2 && pretas == 1) {
						//Rojas:Manual Vs Negras:Automatico
						
						if(damas.getColor() == 'R') {
							if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jugar(damas.getColor(), x, y, i, j)) {
									dibujar_en_los_botones();
									damas.CambioDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.CambioDeTurno();
						}
						
					}
				}
			}
		}
	}
}
