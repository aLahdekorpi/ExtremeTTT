/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Panel which holds the Cells.
 *
 * @author lalex
 */
public class Cell extends JPanel {

    private TwoPlayerGame game;
    private char token = ' ';

    /**
     * Constructor, sets border and adds new MouseListener.
     *
     * @param game Game to which this cell is attached to.
     */
    public Cell(TwoPlayerGame game) {
        this.game = game;
        setBorder(new LineBorder(Color.BLACK, 1));
        addSingleOrDoubleMouseListener();
    }

    public char getToken() {
        return token;
    }

    /**
     * Setter for token.
     *
     * @param token needs to be X or O to work, token must also be empty before
     */
    public void setToken(char token) {
        if (this.token == ' ' && (token == 'X' || token == 'O')) {
            this.token = token;
            repaint();
        }
    }

    /**
     * Draws token to the cell.
     *
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

    public void addSingleOrDoubleMouseListener() {
        if (this.game.getMode() == 'T') {
            addMouseListener(new MyMouseListener(game, Cell.this));
        } else {
            addMouseListener(new SinglePlayerMouseListener(game, Cell.this));
        }
    }

    public void nullifyCell() {
        this.token = ' ';
        repaint();
    }
}
