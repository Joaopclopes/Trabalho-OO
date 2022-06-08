/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dama;

/**
 *
 * @author ice
 */
public class Tabuleiro 
{
    int dimensao = 8;
    Peca pecas;
    
    private static final String ALFABETO = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // util para as coordenadas
    
    
    String tabuleiro[][] = new String [dimensao][dimensao];
    
    public Tabuleiro() {
           

            // espaços vazios no inicio
            this.tabuleiro[0][0] = "   ";

            for(int j = 1; j < this.dimensao; j++) {
                this.tabuleiro[0][j] = String.valueOf(ALFABETO.charAt(j));
            }

            for(int i = 1; i < this.dimensao; i++) {
                String numeroDaLinha = "";

                // Concatenando o valor da linha e mais um espaço em branco para não ficar tudo grudado.
                numeroDaLinha += String.valueOf(i) + " ";

                this.tabuleiro[i][0] = numeroDaLinha;
            }
            
            

            // Preenche todas as posições com -
            for (int linha = 1; linha < this.dimensao; linha++) {
                for (int coluna = 1; coluna < this.dimensao; coluna++) {
                   this.tabuleiro[linha][coluna] = "-";
                }
            }
       
        }
    
    public void MovePeca(int OrigemLinha, int OrigemColuna, int DestinoLinha, int DestinoColuna){
        tabuleiro[DestinoLinha][DestinoColuna] = tabuleiro[OrigemLinha][OrigemColuna];
        tabuleiro[OrigemLinha][OrigemColuna] = null;        
    }
    
    public void MostraTabuleiro(){
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("******************FIM DO TABULEIRO******************");
    }
}
