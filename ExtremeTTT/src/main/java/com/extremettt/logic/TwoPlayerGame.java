/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Frame;
import javax.swing.JFrame;

/**
 * Class contains the logic for a multiplayer game.
 *
 * @author lalex
 */
public class TwoPlayerGame {

    private Cell[][] cells;
    private char whoseTurn = 'X';
    private Frame frame;
    private char mode = 'T';

    /**
     * Constructor.
     * Creates new Frame, uses method initializeGameFrame.
     */
    public TwoPlayerGame() {
        this.frame = new Frame(TwoPlayerGame.this);
        initializeGameFrame();
        this.cells = this.frame.getCells();

    }

    /**
     * Sets title for frame, sets frames size, sets the frame to close when
     * pressing exit, sets location relative to Null, sets the frame visible.
     *
     */
    public void initializeGameFrame() {
        this.frame.setTitle("ExtremeTTT!");
        this.frame.setSize(600, 600);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    /**
     * Checks is gameboard is full.
     *
     * @return true if full, false if not.
     */
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.cells[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if game is won by 3 in a row.
     *
     * @param token Char, X or O, else returns false
     * @return True if game is won, false if not
     */
    public boolean isWonRows(char token) {
        if (!(token == 'O' || token == 'X')) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if ((this.cells[i][0].getToken() == token)
                    && (this.cells[i][1].getToken() == token)
                    && (this.cells[i][2].getToken() == token)) {
                return true;
            }
        }
        return false;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public Frame getFrame() {
        return frame;
    }

    /**
     * Checks if game is won by 3 in a column.
     *
     * @param token Char, X or O, else returns false
     * @return True if game is won, false if not
     */
    public boolean isWonColumns(char token) {
        if (!(token == 'O' || token == 'X')) {
            return false;
        }
        for (int j = 0; j < 3; j++) {
            if ((this.cells[0][j].getToken() == token)
                    && (this.cells[1][j].getToken() == token)
                    && (this.cells[2][j].getToken() == token)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if game is won by 3 in a diagonal line.
     *
     * @param token Char, X or O, else returns false
     * @return True if game is won, false if not
     */
    public boolean isWonDiagonal(char token) {
        if (!(token == 'O' || token == 'X')) {
            return false;
        }
        if ((this.cells[0][0].getToken() == token)
                && (this.cells[1][1].getToken() == token)
                && (this.cells[2][2].getToken() == token)) {
            return true;
        }

        if ((this.cells[0][2].getToken() == token)
                && (this.cells[1][1].getToken() == token)
                && (this.cells[2][0].getToken() == token)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if game is won by any possibility.
     *
     * @return True if game is won by anyone, false if not
     */
    public boolean isWon() {
        if (isWonRows('X')
                || isWonColumns('X')
                || isWonDiagonal('X')
                || isWonRows('O')
                || isWonColumns('O')
                || isWonDiagonal('O')) {
            return true;
        }
        return false;
    }

    /**
     * Setter for whoseTurn.
     * @param whoseTurn Should be O or X for method to work.
     */
    public void setWhoseTurn(char whoseTurn) {
        if (whoseTurn == 'X' || whoseTurn == 'O') {
            this.whoseTurn = whoseTurn;
        }
    }

    /**
     * Getter.
     * @return whoseTurn
     */
    public char getWhoseTurn() {
        return whoseTurn;
    }

    /**
     * Swaps turns.
     */
    public void swapTurns() {
        if (this.whoseTurn == 'X') {
            setWhoseTurn('O');
        } else {
            setWhoseTurn('X');
        }
    }
    public char getMode() {
        return mode;
    }
}
