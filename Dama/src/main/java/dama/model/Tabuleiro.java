package dama.model;


import dama.model.Jogador;
import java.awt.Color;
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
                System.out.println("aqui.");
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
    
    public void InicializaTabuleiro(Jogador A,Jogador B)
    {
        int A_pecaIni =  0,B_pecaIni = 0;
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                while(i < 2)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        A.getPeca(A_pecaIni).getPosicao().set(j, i);
                        A_pecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        A.getPeca(A_pecaIni).getPosicao().set(j, i);
                        A_pecaIni++;
                    }
                                
                }
                
                while(i >= 5 && i < 8)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        B.getPeca(B_pecaIni).getPosicao().set(j, i);
                        B_pecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        B.getPeca(B_pecaIni).getPosicao().set(j, i);
                        B_pecaIni++;
                    }
                }
            }
        }
    }
//    public void MostraTabuleiro(){
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 8; j++){
//                System.out.print(tabuleiro[i][j].peca + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("******************FIM DO TABULEIRO******************");
//    }
        
}
