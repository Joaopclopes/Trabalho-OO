package dama.model;

public abstract class Peca extends Casa
{
    Posicao posicao;
    
    public Peca()
    {
        posicao = getPosicao();
    }
    
    public Posicao getPosicao(){return posicao;};
    
    abstract void MovePeca(Posicao Destino);
    abstract boolean validaPosicao(Posicao pos);
}
