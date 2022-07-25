package dama.model;
//package dama.control.*;


import dama.control.Movimento;
import dama.model.Casa;
import java.util.*;

public class Peca extends Casa 
{

    char cor = 'P';
    Posicao posicao;
    boolean dama;
    boolean eliminada;
    List<Movimento> movimentos;
    List<Posicao>   possiveis;
    
    String peca;
    
    public Posicao getPosicao()  {return posicao;};
    public boolean getD()     {return dama;};
    
    public Peca()
    {
        movimentos = new ArrayList<Movimento>();
        possiveis = new ArrayList<Posicao>();
        posicao   = new Posicao();
    }
    
//    public void Ppossiveis()
//    {
//        for(int i = 0; i < 8; i++)
//        {
//            for(int j = 0; j < 8; j++)
//            {
//                if( i == j && getD() == true || i == getPosicao().getY()  )
//            }
//        }
//    }
    
    public void MovePeca(Posicao Destino)
    {
        if (validaPosicao(Destino) == true)
        {
            posicao.setX(Destino.getX() - getX()); 
            posicao.setY(Destino.getY() - getY());
            Movimento movimento = new Movimento(getPosicao(),Destino);
            movimentos.add(movimento);
        }
        else
        {
            System.out.println("Posição inválida!!!!");
        }
    }
    
    private boolean validaPosicao(Posicao pos)
    {
        if(posicao.getX() + pos.getX() < 8 && posicao.getX() + pos.getX() >= 0 && posicao.getY() + pos.getY() < 8 && posicao.getY() + pos.getY() >= 0)
        {
            if(pos.getX() == posicao.getX()+1 && pos.getY() == posicao.getY()+1 || pos.getX() == posicao.getX()-1 && pos.getY() == posicao.getY()+1)
                return true;
            
            else if(pos.getX() == posicao.getX()+1 && pos.getY() == posicao.getY()-1 || pos.getX() == posicao.getX()-1 && pos.getY() == posicao.getY()-1 && getD() == true)
                return true;
            
            else
                return false;
        }
        
        else
            return false;
    }
    public void AlternaVez() {
		if(cor == 'V') {
			cor = 'P';
		}else {
			cor = 'V';
		}
	}
//    public void possivel_dama() {
//            for (int j = 0; j < this.tabuleiro[0].length; j++) {
//                    if (tabuleiro[0][getY()].cor == 'P') {
//                            tabuleiro[0][j].dama = true;
//                    } else if (tabuleiro[7][getX()].cor == 'V') {
//                            tabuleiro[7][j].dama = false;
//                    }
//		}
//	}    
}
