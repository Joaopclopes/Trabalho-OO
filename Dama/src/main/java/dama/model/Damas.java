package dama.model;

/* Kevin Rodrigo Guerrero Posso
 * esta madre fue un parcial
 */
import javax.swing.JOptionPane;

public class Damas {

	private int tabela[][];
	private final int vermelhas = 1, pretas = 2, damaV = 3, damaP = 4, preenchimento = 5;
	private char color = 'N';
	
	public char getColor() {
		return color;
	}
	public int getPreenchimento() {
		return preenchimento;
	}
	public int getVermelhas() {
		return vermelhas;
	}
	public int getPretas() {
		return pretas;
	}
	public int getdamaV() {
		return damaV;
	}
	public int getdamaP() {
		return damaP;
	}
	
	public void MudaDeTurno() {
		if(color == 'R') {
			color = 'N';
		}else {
			color = 'R';
		}
	}
	
	public Damas() {
		tabela = new int[8][8];
	}

	public int verdamas(int i,int j) {
		posibilidade_dama();
		return tabela[i][j];
	}
	
	public void coloca_pecas() {	
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela.length; j++) {
				if (j % 2 == 0) {
					tabela[1][j] = vermelhas;
					tabela[7][j] = pretas;
					tabela[5][j] = preenchimento;
					tabela[3][j] = preenchimento;
				} else {
					tabela[0][j] = vermelhas;
					tabela[6][j] = pretas;
					tabela[2][j] = preenchimento;
					tabela[4][j] = preenchimento;
				}
			}
		}
	}

	
	public boolean verificar_exitencia_de_peca(char color, int x,int y) {
		if(color == 'N') {
			if(tabela[x][y] == pretas || tabela[x][y] == damaP) {
				return true;
			}
		}else if(color == 'R'){
			if(tabela[x][y] == vermelhas || tabela[x][y] == damaV) {
				return true;
			}
		}
		return false;
	}

	public void buscar_peca(int i,int j) {
		if(tabela[i][j] == getPretas()) {
			System.out.println("preta");
		}else if(tabela[i][j] == getVermelhas()){
			System.out.println("vermelha");
		}
	}
	
	public void mostrartabela() {
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela.length; j++) {
				System.out.print(tabela[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param color
	 */
	public boolean jogar(char color, int x, int y, int x1, int y1) {
		boolean passa = false;
		int variable, dama, inimigo, damainimiga;
		if (color == 'R') {
			inimigo = pretas;
			damainimiga = damaP;
			variable = vermelhas;
			dama = damaV;
		} else {
			damainimiga = damaP;
			inimigo = vermelhas;
			variable = pretas;
			dama = damaP;
		}
		while (passa == false) {
			
			if (tabela[x][y] == variable) {
				if (y1 > -1 && x1 > -1 && y1 < 8 && x1 < 8) {
					if (tabela[x1][y1] == 5) {
						if (variable == pretas) {
							
							if (x1 == x - 1) {
								
								if (y1 == y - 1 || y1 == y + 1) {
									tabela[x][y] = 5;
									tabela[x1][y1] = pretas;
									passa = true;
								}
							}
							if (x1 == x - 2) {
								if (y1 == y + 2) {
									if (tabela[x - 1][y + 1] == inimigo || tabela[x - 1][y + 1] == damainimiga) {
										tabela[x - 1][y + 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = pretas;
										passa = true;
									}
								} else if (y1 == y - 2) {
									if (tabela[x - 1][y - 1] == inimigo || tabela[x - 1][y - 1] == damainimiga) {
										tabela[x - 1][y - 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = pretas;
										passa = true;
									}

								}
							}
							
						} else if (variable == vermelhas) {
							if (x1 == x + 1) {
								if (y1 == y - 1 || y1 == y + 1) {
									tabela[x][y] = 5;
									tabela[x1][y1] = vermelhas;
									passa = true;
								}
							}
							if (x1 == x + 2) {
								if (y1 == y + 2) {
									if (tabela[x + 1][y + 1] == inimigo || tabela[x + 1][y + 1] == damainimiga) {
										tabela[x + 1][y + 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = vermelhas;
										passa = true;
									}
								} else if (y1 == y - 2) {
									if (tabela[x + 1][y - 1] == inimigo || tabela[x + 1][y - 1] == damainimiga) {
										tabela[x + 1][y - 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = vermelhas;
										passa = true;
									}

								}
							}
						}
					}

				} else {
					 //JOptionPane.showMessageDialog(null, "coordenadas no validas");
				}
			} 
			
			
			else if (tabela[x][y] == dama) {
				// movimiento reina
				int menorx = 0, menory = 0;

				if (x == x1 || y == y1) {
					 //JOptionPane.showMessageDialog(null, "movimento invalido por movimento em vertical/horizontal");
				} else if (tabela[x1][y1] == variable) {
					 //JOptionPane.showMessageDialog(null, "movimento invalido por chocar com uma peca aliada");
				} else if (tabela[x1][y1] == 5) {
					for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabela[0].length; i++, j++) {
						if (i == x1 && j == y1) {

							if (x > x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 >= x1; j2--, i2--) {
									if (tabela[j2][i2] == variable || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										passa = true;
									}

								}
							} else if (x < x1 && y < y1) {

								for (int j2 = x, i2 = y; i2 < y1 || j2 < x1; j2++, i2++) {
									tabela[j2][i2] = 5;
									passa = true;
								}
							}

							tabela[x][y] = 5;
							tabela[x1][y1] = dama;
							passa = true;
						}
					}
					for (int i = x, j = y; i >= 0; i--, j++) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabela[0].length; i++, j--) {
						if (i == x1 && j == y1) {
							if (x < x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 < x1; j2++, i2--) {
									if (tabela[j2][i2] == variable || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										passa = true;
									}
								}
							} else if (x > x1 && y < y1) {
								for (int j2 = x, i2 = y; i2 < y1 || j2 >= x1; j2--, i2++) {
									if (tabela[j2][i2] == variable || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										passa = true;
									}
								}
							}
							tabela[x][y] = 5;
							tabela[x1][y1] = dama;
							passa = true;
						}
					}
					if (passa == false) {
						 //JOptionPane.showMessageDialog(null, "movimento invalido");
					} else {
						//JOptionPane.showMessageDialog(null, "movimento ");
					}
				} else {
					 //JOptionPane.showMessageDialog(null, "tem que passar por cima da peca");
				}
			} else {
				 //JOptionPane.showMessageDialog(null, "peca inexistente");
				passa = false;
			}
			if(passa == false) {
				break;
			}
		}
		return passa;
	}

	public boolean verificar(char color) {
		int contadorN = 0, contadorR = 0;
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela[0].length; j++) {
				if (tabela[i][j] == vermelhas || tabela[i][j] == damaV) {
					contadorR++;
				} else if (tabela[i][j] == pretas || tabela[i][j] == damaP) {
					contadorN++;
				}
			}
		}
		if (contadorN == 0 && contadorR > 0) {
			JOptionPane.showMessageDialog(null, "vermelhas ganharam");
			return true;
		} else if (contadorR == 0 && contadorN > 0) {
			JOptionPane.showMessageDialog(null, "pretas ganharam");
			return true;
		}
		return false;
	}

	public void posibilidade_dama() {
		for (int j = 0; j < tabela[0].length; j++) {
			if (tabela[0][j] == pretas) {
				tabela[0][j] = damaP;
			} else if (tabela[7][j] == vermelhas) {
				tabela[7][j] = damaV;
			}
		}
	}
}
