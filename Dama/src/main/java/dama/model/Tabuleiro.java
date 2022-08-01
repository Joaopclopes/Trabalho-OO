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
                    casas[i][j] = new Casa(i, j);
                    casas[i][j].setBackground(Color.white);                   
                    
                }
                else{
                    casas[i][j] = new Casa(i, j);
                    casas[i][j].setBackground(Color.black);
                }
                add(casas[i][j]);
                casas[i][j].setBounds((100 * i),(100 * j),95,95);
                count++;
            }
        }
    }
    
    public void InicializaTabuleiro()
    {
        this.jogadorA = new Jogador();
        this.jogadorB = new Jogador();
        
        int ApecaIni =  0, BpecaIni = 0;
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(j < 3) // aqui uso j como i ( coluna com linha)
                {
                    if((i+j)% 2 != 0){
                        Peao peca = new Peao(i,j);
                        getCasa(i,j).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    }                  
                }
                if(j >= 5 && j < 8){
                    if((i+j)% 2 != 0){
                        Peao peca = new Peao(i,j);
                        getCasa(i,j).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    } 
                }
                
        }
        atualiza();
    }
    }
    
    public void atualiza()
    {
        for(int i = 0;i < 8;i++)
        {
            for(int j = 0;j < 8;j++)
            {
                if(getCasa(i,j).getcomPeca())
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
