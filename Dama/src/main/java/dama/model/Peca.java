package dama.model;



public abstract class Peca extends Casa
{
    public Posicao getPosicao(){return posicao;};
    
    public Peca()
    {
        
    }
    
    abstract void MovePeca(Posicao Destino);
    abstract boolean validaPosicao(Posicao pos);
}
