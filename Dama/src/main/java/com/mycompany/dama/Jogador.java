/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dama;

/**
 *
 * @author ice
 */
public class Jogador 
{
    String nome;
    long tempo_de_jogo;  // inicializa como 0 quando o jogo começa
    int Pontuacao_recorde; 
    Jogador(){
        nome = "";
    }
    Jogador(String Name){
        this.nome = Name;
    }
    public void setNome(String a){
        this.nome = a;
    }
    public String getNome(Jogador A){
        return this.nome;
    }
    public int getPontuacao_recorde(){
        return this.Pontuacao_recorde;
    }
}
