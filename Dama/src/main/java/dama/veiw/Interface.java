/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dama.veiw;
import dama.model.Jogador;
import dama.model.Peao;
import dama.model.Tabuleiro;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
/**
 *
 * @author ice
 */
import java.util.*;
import javax.swing.*;

public class Interface extends JFrame 
{
    private Tabuleiro tab;

    int ORDEM = 8;
    
    public Interface()
    {
        tab = new Tabuleiro();
    }
    public  Tabuleiro getTab(){return tab;}
    
    public static void main(String[] args) 
    {
        Interface jogo = new Interface();
        jogo.getTab().InicializaTabuleiro();
    }
}
