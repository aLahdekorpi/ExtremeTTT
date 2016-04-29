/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Frame;

/**
 * Class to check if game is won.
 *
 * @author lalex
 */
public class WinChecker {

    private TwoPlayerGame game;
    private Cell[][] cells;
    private char whoseTurn = 'X';
    private Frame frame;

    /**
     * Constructor.
     *
     * @param game Game
     */
    public WinChecker(TwoPlayerGame game) {
        this.game = game;
        this.frame = game.getFrame();
        this.cells = game.getCells();
        this.whoseTurn = game.getWhoseTurn();
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
            if ((this.game.getCells()[i][0].getToken() == token)
                    && (this.game.getCells()[i][1].getToken() == token)
                    && (this.game.getCells()[i][2].getToken() == token)) {
                return true;
            }
        }
        return false;
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
            if ((this.game.getCells()[0][j].getToken() == token)
                    && (this.game.getCells()[1][j].getToken() == token)
                    && (this.game.getCells()[2][j].getToken() == token)) {
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
        if ((this.game.getCells()[0][0].getToken() == token)
                && (this.game.getCells()[1][1].getToken() == token)
                && (this.game.getCells()[2][2].getToken() == token)) {
            return true;
        }

        if ((this.game.getCells()[0][2].getToken() == token)
                && (this.game.getCells()[1][1].getToken() == token)
                && (this.game.getCells()[2][0].getToken() == token)) {
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
}
