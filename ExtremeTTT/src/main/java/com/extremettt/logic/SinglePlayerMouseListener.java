/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Cell;
import com.extremettt.logic.TwoPlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * MouseListener to a single player game, what to do when mouse is clicked.
 * @author lalex
 */
public class SinglePlayerMouseListener extends MouseAdapter {

    private Random rand;
    private Cell cell;
    private TwoPlayerGame game;
    private char whoseTurn;
    private char token;
    /**
     * Constructor
     * @param game SinglePlayerGame
     * @param cell Cell
     */
    public SinglePlayerMouseListener(TwoPlayerGame game, Cell cell) {
        this.game = game;
        this.cell = cell;
        this.token = this.cell.getToken();
        this.rand = new Random();
        this.whoseTurn = this.game.getWhoseTurn();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        playTurn();
    }
    /**
     * Play a turn.
     */
    public void playTurn() {
        //if game is full or won, declare winner.
        if (this.game.isFull() || this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText(this.whoseTurn + " won, game is already over");
            return;
        }
        //if cell is empty and its your turn, set token to cell clicked
        if (this.cell.getToken() == ' ' && this.whoseTurn == 'X') {
            this.cell.setToken('X');
        }
        //if game is won, declare winner
        if (this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("You won, gg.");
        // if game is full and not won, declare tie
        } else if (this.game.isFull() && !this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Tie, gf.");
        } else {
            playComputerTurn();
        }
    }
    /**
     * Play a computer turn.
     * Paints a random cell and checks if computer won.
     */
    private void playComputerTurn() {
        paintRandomCellWithO();
        // if game is won, declare winner
        if (this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Computer won, gg.");
        // if game is full and not won, declare tie
        } else if (this.game.isFull() && !this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Tie, gf.");
        }
    }
    /**
     * Creates two random integers(0,1 or 2) and paints a cell representing those.
     */
    private void paintRandomCellWithO() {
        int randomX;
        int randomY;
        while(true){
            randomX = randomizeZeroToTwo();
            randomY = randomizeZeroToTwo();
            if (this.game.getCells()[randomX][randomY].getToken() == ' '){
                this.game.getCells()[randomX][randomY].setToken('O');
                break;
            }
        }
    }
    /**
     * Creates random integer(0,1 or 2).
     * @return 0, 1 or 2.
     */
    private int randomizeZeroToTwo(){
        Double randomD;
        randomD = Math.random();
        if(randomD < 0.33){
            return 0;
        }
        if(randomD < 0.66){
            return 1;
        } else {
            return 2;
        }
    }

}
