/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.model;

/**
 *
 * @author ice
 */

import javax.swing.JButton;
public class Casa extends JButton
{
    private
    Posicao posicao;
    boolean preto = false;
    
    void setPreto(boolean a){this.preto = a;};
}
