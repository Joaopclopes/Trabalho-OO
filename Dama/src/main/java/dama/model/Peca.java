package dama.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Peca extends Casa
{
    Posicao posicao;
    
    
    
    public Peca()
    {
        posicao = getPosicao();
    }
    
    public Posicao getPosicao(){return posicao;};
    public void InserePeca(int i, int j){
        if(getCasa(i,j).getcomPeca())
                {
                    Icon icon = new ImageIcon("pecapreta.png");
                    getCasa(i,j).setIcon(icon);
                }
    }
    
    abstract void MovePeca(Posicao Destino);
    abstract boolean validaPosicao(Posicao pos);
}
