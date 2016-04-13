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
 * Panel which holds the Cells
 * @author lalex
 */
public class Cell extends JPanel {

    private char token = ' ';

    public Cell() {
        setBorder(new LineBorder(Color.BLACK, 1));
        addMouseListener(new MyMouseListener(true));
    }

    public char getToken() {
        return token;
    }
    /**
     * Setter for token
     * @param token needs to be X or Y to work, token must also be empty before
     */
    public void setToken(char token) {
        if (this.token == ' ' && (token == 'X' || token == 'Y')) {
            this.token = token;
            repaint();
        }
    }
    /**
     * Draws token to the cell 
     * @param g graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (token == 'X') {
            g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
            g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
        } else if (token == 'O') {
            g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
        }
    }
}
