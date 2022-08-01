package dama.model;
//package dama.control.*;


import dama.control.Movimento;
import java.util.*;

public class Peao extends Peca 
{
    boolean eliminada;
    List<Movimento> movimentos;

    public Peao(int i, int j)
    {
        super(i, j);
    }
    
    
    
    public void MovePeca(Posicao Destino)
    {
        if (validaPosicao(Destino) == true)
        {
//            posicao = 
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
        if(pos.getX() == posicao.getX()+1 && pos.getY() == posicao.getY()+1 || pos.getX() == posicao.getX()-1 && pos.getY() == posicao.getY()+1)
            return true;
        else
            return false;
    }
}    
