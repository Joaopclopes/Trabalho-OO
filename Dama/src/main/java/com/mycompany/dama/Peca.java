/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dama;

/**
 *
 * @author ice
 */
public class Peca 
{
    int x, y;
    boolean dama;
    boolean eliminada;
    
    String peca;
    
    public int     getX()     {return this.x;};
    private void   setX(int x){this.x = this.x + x;};
    public int     getY()     {return this.y;};
    private void   setY(int y){this.y = this.y + y;};
    public boolean getD()     {return dama;};
    
    public void MovePeca(int DestinoLinha, int DestinoColuna)
    {
        if (validaPosicao(DestinoLinha, DestinoColuna) == true)
        {
            setX(DestinoLinha - getX());
            setY(DestinoColuna - getY());
        }
        else
        {
            System.out.println("Posição inválida!!!!");
        }
    }
    
    private boolean validaPosicao(int x_des, int y_des)
    {
        if(getX() + x_des < 8 && getX() + x_des >= 0 && getY() + y_des < 8 && getY() + y_des >= 0)
        {
            if(x_des == getX()+1 && y_des == getY()+1 || x_des == getX()-1 && y_des == getY()+1)
                return true;
            
            else if(x_des == getX()+1 && y_des == getY()-1 || x_des == getX()-1 && y_des == getY()-1 && getD() == true)
                return true;
            
            else
                return false;
        }
        
        else
            return false;
    }
}