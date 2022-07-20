package dama.model;


import dama.model.Jogador;
import javax.swing.JFrame;
/**
 *
 * @author ice
 */
public class Tabuleiro
{
    final int dimensao = 8;
    Casa  casas[][];
   
   int getDimensao(){return dimensao;};
    
    public Tabuleiro() 
    {
        this.casas = new Casa[8][8];
        
        for(int i = 0;i < getDimensao();i++)
        {
            for(int j = 0;i < getDimensao();i++)
            {
                if((j%2 != 0 && i%2 == 0) || (j%2 == 0 && i%2 != 0))
                    casas[i][j].setPreto(true);
                    
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
                        A.getPeca(A_pecaIni).setX(j);
                        A.getPeca(A_pecaIni).setY(i);
                        A_pecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        A.getPeca(A_pecaIni).setX(j);
                        A.getPeca(A_pecaIni).setY(i);
                        A_pecaIni++;
                    }
                                
                }
                
                while(i >= 5 && i < 8)
                {
                    if(j%2 != 0 && i%2 == 0)
                    {
                        B.getPeca(B_pecaIni).setX(j);
                        B.getPeca(B_pecaIni).setY(i);
                        B_pecaIni++;
                    }
                    else if(j%2 == 0)
                    {
                        B.getPeca(B_pecaIni).setX(j);
                        B.getPeca(B_pecaIni).setY(i);
                        B_pecaIni++;
                    }
                }
            }
        }
    }
    public void MostraTabuleiro(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(tabuleiro[i][j].peca + " ");
            }
            System.out.println();
        }
        System.out.println("******************FIM DO TABULEIRO******************");
    }
        
}
