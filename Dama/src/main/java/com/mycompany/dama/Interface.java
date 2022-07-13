/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dama;

/**
 *
 * @author ice
 */
import java.util.*;
import javax.swing.*;

public class Interface extends JFrame 
{
    private Jogador   jogador_A,jogador_B;
    private Tabuleiro tabuleiro;
    
    JButton[] bt = new JButton[64];
    
    public Interface()
    {
    }
    public static void main(String[] args) 
    {
        new Interface();
    }
}