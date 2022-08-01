/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.model;

/**
 *
 * @author jpcl2
 */
import dama.control.Movimento;
import dama.model.Casa;
import java.util.*;

public class Dama extends Peca
{
    List<Posicao> possiveis;
    List<Movimento> movimentos;
    
    public Dama()
    {
        possiveis = new ArrayList<>();
        
        for(int i = 0;i < 8;i++)
        {
            for(int j = 0;j < 8;j++)
            {
                if(i - getPosicao().getY() == j - getPosicao().getX())
                {
                    Posicao posicao = new Posicao(j,i);
                    possiveis.add(posicao);
                }
            }
        }
    }
    public void MovePeca(Posicao Destino)
    {
        if (validaPosicao(Destino) == true)
        {
            posicao = getCasa(Destino.getX(),Destino.getY()).getPosicao();
            Movimento movimento = new Movimento(getPosicao(),Destino);
            movimentos.add(movimento);
        }
        else
        {
            System.out.println("Posição inválida!!!!");
        }
    }
    public boolean validaPosicao(Posicao pos)
    {
        if(pos.getY() - getPosicao().getY() == pos.getX() - getPosicao().getX())
            return true;
        else
            return false;
    }
}
