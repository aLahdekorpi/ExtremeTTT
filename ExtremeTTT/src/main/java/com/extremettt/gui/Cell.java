/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 *
 * @author lalex
 */
//panel which holds the tokens
public class Cell extends JPanel {

    private char token = ' ';

    public Cell() {
        setBorder(new LineBorder(Color.BLACK, 1));
        addMouseListener(new MyMouseListener(true));
    }

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
