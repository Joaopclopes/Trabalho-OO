package dama.model;


import dama.model.Jogador;
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
    List<Casa> casas;
    private Jogador   jogadorA,jogadorB;
   
   int getDimensao(){return dimensao;};
    
    public Tabuleiro() 
    {
        casas = new ArrayList<>();
        
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
                Casa casa = new Casa(j,i,casas);
                if((i+j)% 2 == 0)
                    casa.setBackground(Color.white);
                else
                    casa.setBackground(Color.black);
                
                add(casa);
                casas.add(casa);
                casas.get(count).setBounds((100 * i),(100 * j),95,95);
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
                while(i < 2)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        Peao peca = new Peao();
                        getCasa(j,i).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        Peao peca = new Peao();
                        getCasa(j,i).setPeca(peca);
                        jogadorA.getPeca().add(peca);
                        ApecaIni++;
                    }
                                
                }
                
                while(i >= 5 && i < 8)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        Peao peca = new Peao();
                        getCasa(j,i).setPeca(peca);
                        jogadorB.getPeca().add(peca);
                        BpecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        Peao peca = new Peao();
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
                    Icon icon = new ImageIcon("pecapreta.png");
                    getCasa(j,i).setIcon(icon);
                }
            }
        }
    }
    
    public Casa getCasa(int x,int y)
    {
        for(Casa i : casas)
        {
            if(i.getX() == x && i.getY() == y)
                return i;
        }
        return null;
    }
}
