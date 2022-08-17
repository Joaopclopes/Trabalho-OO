package dama.model;


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
		}else if(color == 'N'){
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
	
	
	public void imprimir(int contadorN, int contadorR, char color) {
//		System.out.println();
//		for (int i = 0; i < tabla.length; i++) {
//			System.out.println("----------------------------------------");
//			for (int j = 0; j < tabla[0].length; j++) {
//				if (tabla[i][j] == rojas) {
//					System.out.print(" R  |");
//				} else if (tabla[i][j] == negras) {
//					System.out.print(" N  |");
//				} else if (tabla[i][j] == reinaR) {
//					System.out.print(" RR |");
//				} else if (tabla[i][j] == reinaN) {
//					System.out.print(" RN |");
//				} else if (tabla[i][j] == 5) {
//					System.out.print("----|");
//				} else if (i == 4 && j == 7) {
//					System.out.print("    | Negras:");
//				} else if (i == 5 && j == 7) {
//					System.out.print("    | Rojas:");
//				} else if (i == 3 && j == 7 && color == 'R') {
//					System.out.print("    | Rojas");
//				} else if (i == 3 && j == 7 && color == 'N') {
//					System.out.print("    | Negras");
//				} else {
//					System.out.print("    |");
//				}
//				if (i == 2 && j == 7) {
//					System.out.print(" Turno De:");
//				}
//			}
//
//			System.out.println();
//		}
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
		boolean pasa = false;
		int variavel, dama, inimigo, dama_inimiga;
		if (color == 'R') {
			inimigo = pretas;
			dama_inimiga = damaP;
			variavel = vermelhas;
			dama = damaV;
		} else {
			dama_inimiga = damaP;
			inimigo = vermelhas;
			variavel = pretas;
			dama = damaP;
		}
		while (pasa == false) {
			
			if (tabela[x][y] == variavel) {
				if (y1 > -1 && x1 > -1 && y1 < 8 && x1 < 8) {
					if (tabela[x1][y1] == 5) {
						if (variavel == pretas) {
							
							if (x1 == x - 1) {
								
								if (y1 == y - 1 || y1 == y + 1) {
									tabela[x][y] = 5;
									tabela[x1][y1] = pretas;
									pasa = true;
								}
							}
							if (x1 == x - 2) {
								if (y1 == y + 2) {
									if (tabela[x - 1][y + 1] == inimigo || tabela[x - 1][y + 1] == dama_inimiga) {
										tabela[x - 1][y + 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = pretas;
										pasa = true;
									}
								} else if (y1 == y - 2) {
									if (tabela[x - 1][y - 1] == inimigo || tabela[x - 1][y - 1] == dama_inimiga) {
										tabela[x - 1][y - 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = pretas;
										pasa = true;
									}

								}
							}
							
						} else if (variavel == vermelhas) {
							if (x1 == x + 1) {
								if (y1 == y - 1 || y1 == y + 1) {
									tabela[x][y] = 5;
									tabela[x1][y1] = vermelhas;
									pasa = true;
								}
							}
							if (x1 == x + 2) {
								if (y1 == y + 2) {
									if (tabela[x + 1][y + 1] == inimigo || tabela[x + 1][y + 1] == dama_inimiga) {
										tabela[x + 1][y + 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = vermelhas;
										pasa = true;
									}
								} else if (y1 == y - 2) {
									if (tabela[x + 1][y - 1] == inimigo || tabela[x + 1][y - 1] == dama_inimiga) {
										tabela[x + 1][y - 1] = 5;
										tabela[x][y] = 5;
										tabela[x1][y1] = vermelhas;
										pasa = true;
									}

								}
							}
						}
					}

				} else {
					 JOptionPane.showMessageDialog(null, "coordenadas inválidas");
				}
			} 
			
			
			else if (tabela[x][y] == dama) {
				
				int menorx = 0, menory = 0;

				if (x == x1 || y == y1) {
					 JOptionPane.showMessageDialog(null, "movimento inválido: desclocamento na horizontal e na vertical.");
				} else if (tabela[x1][y1] == variavel) {
					 JOptionPane.showMessageDialog(null, "movimento invalido por chocar con uma peça aliada");
				} else if (tabela[x1][y1] == 5) {
					for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabela[0].length; i++, j++) {
						if (i == x1 && j == y1) {

							if (x > x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 >= x1; j2--, i2--) {
									if (tabela[j2][i2] == variavel || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										pasa = true;
									}

								}
							} else if (x < x1 && y < y1) {

								for (int j2 = x, i2 = y; i2 < y1 || j2 < x1; j2++, i2++) {
									tabela[j2][i2] = 5;
									pasa = true;
								}
							}

							tabela[x][y] = 5;
							tabela[x1][y1] = dama;
							pasa = true;
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
									if (tabela[j2][i2] == variavel || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										pasa = true;
									}
								}
							} else if (x > x1 && y < y1) {
								for (int j2 = x, i2 = y; i2 < y1 || j2 >= x1; j2--, i2++) {
									if (tabela[j2][i2] == variavel || tabela[j2][i2] == dama) {

									} else {
										tabela[j2][i2] = 5;
										pasa = true;
									}
								}
							}
							tabela[x][y] = 5;
							tabela[x1][y1] = dama;
							pasa = true;
						}
					}
					if (pasa == false) {
						 //JOptionPane.showMessageDialog(null, "movimento invalido!!");
					} else {
						//JOptionPane.showMessageDialog(null, "movimento feito!");
					}
				} else {
					 JOptionPane.showMessageDialog(null, "tem que comer a peça adversária");
				}
			} else {
				 //JOptionPane.showMessageDialog(null, "peça inesistente");
				pasa = false;
			}
			if(pasa == false) {
				break;
			}
		}
		return pasa;
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
		imprimir(contadorN, contadorR, color);
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
