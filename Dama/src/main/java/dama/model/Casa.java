/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.model;

/**
 *
 * @author ice
 */

import javax.swing.JButton;
import java.util.*;
public class Casa extends JButton
{
    private
    Posicao posicao;
    boolean comPeca;
    Peca peca;
    List<Casa> casass;
    
    public Posicao getPosicao(){return this.posicao;};
    public Peca getPeca(){return peca;};
    
    public Casa(int i,int j,List<Casa> casas)
    {
        posicao = new Posicao(i,j);
        comPeca = false;
        peca    = null;
        casass  = casas;
    }
    
    public Casa getCasa(int x,int y)
    {
        for(Casa i : casass)
        {
            if(i.getX() == x && i.getY() == y)
                return i;
        }
        return null;
    }
}
