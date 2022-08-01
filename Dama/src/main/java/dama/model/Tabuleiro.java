package dama.model;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author ice
 */
public class Tabuleiro extends JFrame
{
    final int dimensao = 8;
    Casa casas[][];
    private Jogador   jogadorA,jogadorB;
   
   int getDimensao(){return dimensao;};
    
    public Tabuleiro() 
    {
        casas = new Casa[8][8];
        
        setVisible(true);
        setTitle("Dama");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setBounds(250,100,815,840);
        int count = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if((i+j)% 2 == 0){
                    casas[j][i] = new Casa(j, i);
                    casas[j][i].setBackground(Color.white);
                }
                else{
                    casas[j][i] = new Casa(j, i);
                    casas[j][i].setBackground(Color.black);
                }
                add(casas[j][i]);
                casas[j][i].setBounds((100 * i),(100 * j),95,95);
                count++;
            }
        }
    }
    
    public void InicializaTabuleiro()
    {
        this.jogadorA = new Jogador();
        this.jogadorB = new Jogador();
        
        int ApecaIni =  0,BpecaIni = 0;
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(i < 3)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        Peao peca = new Peao(j,i);
                        getCasa(j,i).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        Peao peca = new Peao(j,i);
                        getCasa(j,i).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    }
                                
                }
                
                else if(i >= 5 && i < 8)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        Peao peca = new Peao(j,i);
                        getCasa(j,i).setPeca(peca);
                        jogadorB.getPeca().add(peca);
                        BpecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        Peao peca = new Peao(j,i);
                        getCasa(j,i).setPeca(peca);
                        jogadorB.getPeca().add(peca);
                        BpecaIni++;
                    }
                }
            }
        }
        atualiza();
    }
    
    public void atualiza()
    {
        for(int i = 0;i < 8;i++)
        {
            for(int j = 0;j < 8;j++)
            {
                if(getCasa(j,i).getcomPeca())
                {
                    getCasa(i,j).setIcon(new ImageIcon("./imagens/pecapreta.png"));
                }
            }
        }
    }
    
    public Casa getCasa(int x,int y)
    {
        return casas[x][y];
    }
}
