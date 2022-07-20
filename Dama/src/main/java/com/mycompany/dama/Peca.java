package com.mycompany.dama;

import javax.swing.JButton;

import java.util.*;

public class Peca extends JButton 
{

    char cor = 'P';
    int x, y;
    boolean dama;
    boolean eliminada;
    List<Movimento> movimentos; // lista para armazenar possíveis movimentos??
    Peca tabuleiro[][] = new Peca [8][8];
    
    String peca;
    
    public int     getX()     {return this.x;};
    public void    setX(int x) {this.x = this.x + x;};
    public int     getY()     {return this.y;};
    public void    setY(int y) {this.y = this.y + y;};
    public boolean getD()     {return dama;};
    
    public Peca()
    {
        movimentos = new ArrayList<Movimento>();
    }
    
    
    public void MovePeca(int DestinoLinha, int DestinoColuna)
    {
        if (validaPosicao(DestinoLinha, DestinoColuna) == true)
        {
            setX(DestinoLinha - getX()); 
            setY(DestinoColuna - getY());
            Movimento movimento = new Movimento(getX(),getY(),DestinoColuna,DestinoLinha);
            movimentos.add(movimento);
        }
        else
        {
            System.out.println("Posição inválida!!!!");
        }
    }
    
    private boolean validaPosicao(int x_des, int y_des)
    {
        if(getX() + x_des < 8 && getX() + x_des >= 0 && getY() + y_des < 8 && getY() + y_des >= 0)
        {
            if(x_des == getX()+1 && y_des == getY()+1 || x_des == getX()-1 && y_des == getY()+1)
                return true;
            
            else if(x_des == getX()+1 && y_des == getY()-1 || x_des == getX()-1 && y_des == getY()-1 && getD() == true)
                return true;
            
            else
                return false;
        }
        
        else
            return false;
    }
    public void AlternaVez() {
		if(cor == 'V') {
			cor = 'P';
		}else {
			cor = 'V';
		}
	}
    public void possivel_dama() {
            for (int j = 0; j < this.tabuleiro[0].length; j++) {
                    if (tabuleiro[0][getY()].cor == 'P') {
                            tabuleiro[0][j].dama = true;
                    } else if (tabuleiro[7][getX()].cor == 'V') {
                            tabuleiro[7][j].dama = false;
                    }
		}
	}    
}
