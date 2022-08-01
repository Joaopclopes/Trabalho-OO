package dama.model;

import java.util.List;



public abstract class Peca extends Casa
{
    public Posicao getPosicao(){return posicao;};

    public Peca(int i, int j) {
        super(i, j);
    }
    
    abstract void MovePeca(Posicao Destino);
    abstract boolean validaPosicao(Posicao pos);
}
