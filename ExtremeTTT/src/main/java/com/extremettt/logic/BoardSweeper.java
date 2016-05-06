/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

/**
 * Class to clear a gameboard.
 *
 * @author lalex
 */
public class BoardSweeper {

    private TwoPlayerGame game;
    /**
     * Constructor.
     * @param game TwoPlayerGame 
     */
    public BoardSweeper(TwoPlayerGame game) {
        this.game = game;
    }

    /**
     * Clears token from every cell on board.
     */
    public void nullifyGameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.game.getCells()[i][j].nullifyCell();
            }
        }
    }
}
