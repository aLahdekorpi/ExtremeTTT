/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Main GUI class, Frame.
 *
 * @author lalex
 */
public class Frame extends JFrame {

    private Cell[][] cells = new Cell[3][3];
    private TwoPlayerGame game;
    public JLabel jlblStatus = new JLabel("X's turn to play");
    public JLabel score = new JLabel("X: 0 O: 0");
    private char whoseTurn = 'X';

    /**
     * Constructor, also uses method initializeFrame.
     *
     * @param game Game to which this frame is attached into
     */
    public Frame(TwoPlayerGame game) {
        this.game = game;
        initializeFrame();
        //initializeScore();
    }

    /**
     * Creates new panel through method newPanelWithCells, sets borders to panel
     * and JLabel.
     */
    public void initializeFrame() {
        JPanel panel = newPanelWithCells();
        panel.setBorder(new LineBorder(Color.red, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));
        score.setBorder(new LineBorder(Color.blue, 1));
        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
        add(score, BorderLayout.EAST);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public char getWhoseTurn() {
        return whoseTurn;
    }

    public JLabel getJlblStatus() {
        return jlblStatus;
    }

    public void setJlblStatus(JLabel jlblStatus) {
        this.jlblStatus = jlblStatus;
    }

    /**
     * Creates new JPanel full of empty cells.
     *
     * @return JPanel full of empty cells
     */
    public JPanel newPanelWithCells() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell cell = new Cell(game);
                panel.add(cells[i][j] = cell);
            }
        }
        return panel;
    }

}
