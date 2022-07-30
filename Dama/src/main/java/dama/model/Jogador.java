/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.model;

/**
 *
 * @author ice
 */
import java.util.*;
public class Jogador 
{
    String nome;
    long   tempo_de_jogo;  // inicializa como 0 quando o jogo começa
    int    Pontuacao_recorde;
    List<Peao> pecas;
    
    
    public String getNome(Jogador A){return this.nome;}
    private void  setNome(String a) {this.nome = a;}
    public  Peao  getPeca(int i)    {return this.pecas.get(i);};
    public int    getPontuacao_recorde(){return this.Pontuacao_recorde;}
    
    public Jogador()
    {
        pecas = new ArrayList<>();
    }
}
