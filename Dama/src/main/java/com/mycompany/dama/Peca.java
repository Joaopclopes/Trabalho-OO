/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dama;

/**
 *
 * @author ice
 */
public class Peca 
{
    boolean dama;
    String peca;
    Jogador A = new Jogador();
    Tabuleiro [][]tabuleiro = new Tabuleiro[8][8];
    
    public void MovePeca(int OrigemLinha, int OrigemColuna, int DestinoLinha, int DestinoColuna){
        if (validaPosicao(DestinoLinha, DestinoColuna) == true)
        {
            tabuleiro[DestinoLinha][DestinoColuna] = tabuleiro[OrigemLinha][OrigemColuna];
            tabuleiro[OrigemLinha][OrigemColuna] = null;        
        }
        else{
            System.out.println("Posição inválida!!!!");
        }
}
    public boolean validaPosicao(int x, int y){
        // tentei usar uma formula pra validar uma posição na matriz
        for(x = 0; x < 8; x++){
            for(y = 0; y < 8; y++){
                if( x % 2 != 0 && y % 2 != 0){
                    return true;
                } if(x % 2 == 0 && y % 2 == 0){
                    return true;
                }                
            }
    }
        return false;
    }
    
    /*public void mover(int)*/
}
