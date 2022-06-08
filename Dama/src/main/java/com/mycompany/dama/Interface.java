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
    JButton[] bt = new JButton[64];
    public Interface()
    {
        setVisible(true);
        setTitle("====Dama====");
        setDefaultCloseOperation(2);
        setLayout(null);
        setBounds(250,100,700,700);
        int cont = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((60 * i) + 100,(60 * j) + 100, 60 ,60);
                cont++;
            }
        }
    }
    public static void main(String[] args) 
    {
        new Interface();
    }
}