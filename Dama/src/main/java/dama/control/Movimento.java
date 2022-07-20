/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.control;

import dama.model.Posicao;

/**
 *
 * @author ice
 */
public class Movimento 
{
    public Posicao inicial,destino;
    
    void    setInicial(Posicao posicao){this.inicial = posicao;};
    Posicao getInicial()               {return inicial;};
    void    setDestino(Posicao posicao){this.destino = posicao;};
    Posicao getDestino()               {return destino;};
    
    public Movimento(Posicao inicial,Posicao destino)
    {
        setInicial(inicial);
        setDestino(destino);
    }
}
