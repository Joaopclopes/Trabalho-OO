package dama.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.LinkedList;

public abstract class Peca extends Casa
{    
    int xp;
    int yp;
    boolean ehBranca;// verifica se é branca
    LinkedList<Peca> ps; // lista de peças
    String nome;
    
    public Peca(int xp, int yp, boolean ehBranca, String n, LinkedList <Peca> ps)
    {
        this.xp = xp;
        this.yp = yp;
        this.ehBranca = ehBranca;
        this.ps = ps;
        nome = n;
        ps.add(this);
    }
    public Peca getPeca(int x,int y){
        xp=x;
        yp=y;
        for(Peca p: ps){
            if(p.xp==xp && p.yp==yp){
                return p;
            }
        }
        return null;
    }
    
    public void move(int xp, int yp){
        if(this.getPeca(xp, yp)!= null){
            if(this.getPeca(xp, yp).ehBranca !=ehBranca){
                this.getPeca(xp, yp).come();
                
            }else{
                this.xp=xp;
                this.yp=yp;

        }
        }
    }

    public void come(){
        ps.remove(this);
    }
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
