/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Frame;

/**
 * Class to check if gameboard is full.
 *
 * @author lalex
 */
public class FullChecker {

    private TwoPlayerGame game;
    private char whoseTurn = 'X';
    private Frame frame;
    /** 
     * Constructor.
     * @param game TwoPlayerGame
     */
    public FullChecker(TwoPlayerGame game) {
        this.game = game;
        this.frame = game.getFrame();
        this.whoseTurn = game.getWhoseTurn();
    }

    /**
     * Checks is gameboard is full.
     *
     * @return true if full, false if not.
     */
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.game.getCells()[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
