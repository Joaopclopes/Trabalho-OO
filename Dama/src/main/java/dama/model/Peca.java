/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.model;

/**
 *
 * @author jpcl2
 */
import java.util.*;
public abstract class Peca extends Casa
{
    Posicao posicao;
    
    public Peca()
    {
        posicao = getPosicao();
    }
    
    abstract void MovePeca(Posicao Destino);
    abstract boolean validaPosicao(Posicao pos);
}
