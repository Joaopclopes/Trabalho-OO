/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.veiw;
import dama.model.Jogador;
import dama.model.Peca;
import dama.model.Tabuleiro;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
/**
 *
 * @author ice
 */
import java.util.*;
import javax.swing.*;

public class Interface extends JFrame 
{
    private Jogador   jogador_A,jogador_B;
    private Tabuleiro tab;    
    //JButton[] bt = new JButton[64];
    JPanel painel;

    int ORDEM = 8;
    
    JButton[] bt = new JButton[64];
    public Interface()
    {
        this.painel = new JPanel();
//        tab = new Tabuleiro();
//        tab.InicializaTabuleiro( jogador_A, jogador_B);
        
        setVisible(true);
        setTitle("Dama");
        setDefaultCloseOperation(3);
        setLayout(null);
        setBounds(250,100,700,500);
        int count = 0;
        for(int i = 0; i < ORDEM; i++)
        {
            for(int j = 0; j < ORDEM; j++)
            {
                bt[count] = new JButton();
                add(bt[count]);
                bt[count].setBounds((100 * i) + 50,(100 * j) + 50,95,95);
                count++;
            }
        }
    }
    
//    public void desenha(){
//        
//        painel.setLayout(new GridLayout(ORDEM, ORDEM));
//        
//        for (int i = 0; i < ORDEM; i++)
//        {
//            for (int j = 0; j < ORDEM; j++)
//            {
//                add
////                casa.addActionListener(new Jogar(campo));
//                //peca.addMouseListener(new Jogar(tab, this));
//                
//                peca.setPreferredSize(new Dimension(50, 50));
//                peca.setBorder(BorderFactory.createLineBorder(Color.black));
//                painel.add(peca);
//            }
//        }
//        
//        this.add(painel);
//        this.setVisible(true);
//        this.setSize(500,500);
//        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        this.repaint();
//        this.pack();
//    }
    
    
    public static void main(String[] args) 
    {
        Interface jogo = new Interface();
        
    }
}
