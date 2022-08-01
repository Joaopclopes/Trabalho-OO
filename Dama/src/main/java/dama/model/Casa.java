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
    boolean comPeca;
    Posicao posicao;
    Peca peca;
    
    public Posicao getPosicao(){return this.posicao;};
    public Peca    getPeca()   {return peca;};
    public boolean getcomPeca(){return comPeca;};
    
    public Casa(int i,int j)
    {
        posicao = new Posicao(i,j);
        comPeca = false;
        peca    = null;
    }
    
    
    public void setPeca(Peca pecaD)
    {
        peca = pecaD;
        this.comPeca = true;
    }
}
