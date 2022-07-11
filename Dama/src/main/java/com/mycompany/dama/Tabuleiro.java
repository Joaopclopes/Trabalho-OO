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
    
    // inicializa as posições
    public void InicializaTabuleiro(String tabuleiro[][]){
        for(int i = 0; i < (dimensao / 2); i++){
            for(int j = 0; j < (dimensao/ 2); j++){
                if(i % 2 != 0 && j % 2 == 0){
                    this.tabuleiro[i][j].peca.equals("X");
                }
                }
            }
        for(int i = 6; i < dimensao; i++){
            for(int j = 0; j < (dimensao/2); j++){
                if(i % 2 == 0 && j % 2 != 0){
                    this.tabuleiro[i][j].peca.equals("W");
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
