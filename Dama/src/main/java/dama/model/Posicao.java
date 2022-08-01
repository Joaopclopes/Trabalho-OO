/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dama.model;

/**
 *
 * @author ice
 */
public class Posicao 
{
    int x, y;
    
    public Posicao(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public Posicao()
    {
    }
    
    void setX(int i){this.x = i;};
    int  getX()     {return this.x;};
    void setY(int i){this.y = i;};
    int  getY()     {return this.y;};
    void set(int i, int j){this.x = i; this.y = j;};
}
