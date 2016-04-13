/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author lalex
 */
public class Frame extends JFrame {

    //create the grid
    private Cell[][] cells = new Cell[3][3];

    JLabel jlblStatus = new JLabel("X's turn to play");
    private char whoseTurn = 'X';

    public Frame() {
        JPanel panel = newPanelWithCells();
        panel.setBorder(new LineBorder(Color.red, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));
        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public char getWhoseTurn() {
        return whoseTurn;
    }
    /**
     * Creates new JPanel full of empty cells
     * @return JPanel full of empty cells
     */
    public JPanel newPanelWithCells(){
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(cells[i][j] = new Cell());
            }
        }
        return panel;
    }

}
