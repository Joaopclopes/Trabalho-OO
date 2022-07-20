package com.mycompany.dama;


import javax.swing.JFrame;
/**
 *
 * @author ice
 */
public class Tabuleiro
{
    int dimensao = 8;
    
    
    private static final String Alfabeto = "0ABCDEFGH"; // util para as coordenadas
    
    
    Peca tabuleiro[][] = new Peca [dimensao][dimensao];
    
    public Tabuleiro() 
    {          

            // espaços vazios no inicio
            this.tabuleiro[0][0].peca = " ";

            for(int j = 1; j < this.dimensao; j++) {
                this.tabuleiro[0][j].peca = String.valueOf(Alfabeto.charAt(j));
            }

            for(int i = 1; i < this.dimensao; i++) {
                String numeroDaLinha = "";

                // evita os espaços grudados
                numeroDaLinha += String.valueOf(i) + " ";

                this.tabuleiro[i][0].peca = numeroDaLinha;
            }          
            

            // Todas as posições inicialmente começam com "-"
        for (int i = 1; i < this.dimensao; i++) {
                for (int j = 1; j < this.dimensao; j++) {
                   this.tabuleiro[i][j].peca = " ";
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
