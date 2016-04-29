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
    private final char mode = 'T';
    private int winsX;
    private int winsO;

    /**
     * Constructor. Creates new Frame, uses method initializeGameFrame.
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

    public Cell[][] getCells() {
        return this.cells;
    }

    public Frame getFrame() {
        return frame;
    }

    /**
     * Setter for whoseTurn.
     *
     * @param whoseTurn Should be O or X for method to work.
     */
    public void setWhoseTurn(char whoseTurn) {
        if (whoseTurn == 'X' || whoseTurn == 'O') {
            this.whoseTurn = whoseTurn;
        }
    }

    /**
     * Getter.
     *
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

    /**
     * Clears token from every cell on board.
     */
    public void nullifyGameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j].nullifyCell();
            }
        }
    }

    /**
     * Adds +1 to winsX or winsO depending on whose turn it is.
     */
    public void addPointToWinner() {
        if (this.whoseTurn == 'X') {
            this.winsX++;
        }
        if (this.whoseTurn == 'O') {
            this.winsO++;
        }
    }

    public int getWinsX() {
        return winsX;
    }

    public int getWinsO() {
        return winsO;
    }

}
