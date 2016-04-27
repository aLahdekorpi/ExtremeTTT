/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * MouseListener to a single player game, what to do when mouse is clicked.
 *
 * @author lalex
 */
public class SinglePlayerMouseListener extends MouseAdapter {

    private Random rand;
    private Cell cell;
    private TwoPlayerGame game;
    private char whoseTurn;
    private char token;
    private int winsX;
    private int winsO;
    private boolean isClicked;

    /**
     * Constructor
     *
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
    public void playTurn() {;
        this.game.setWhoseTurn('X');
        if (this.cell.getToken() != ' ') {
            return;
        }
        //if game is full or won, declare winner.
        if (this.game.isFull() || this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Game is already over");
            return;
        }
        //if cell is empty and its your turn, set token to cell clicked
        if (this.cell.getToken() == ' ' && this.whoseTurn != ' ') {
            this.cell.setToken('X');
            this.game.getFrame().jlblStatus.setText(this.whoseTurn + "'s turn");
        }
        //if game is won, declare winner
        if (this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("You won, gg.");
            this.game.addPointToWinner();
            newGame();
            // if game is full and not won, declare tie
        }
        if (this.game.isFull() && !this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Tie, gf.");
            newGame();
        } else {
            playComputerTurn();
        }
        this.game.getFrame().score.setText("X: " + this.game.getWinsX() + " O: " + this.game.getWinsO());
    }

    /**
     * Play a computer turn. Paints a random cell and checks if computer won.
     */
    private void playComputerTurn() {
        this.game.setWhoseTurn('O');
        paintRandomCellWithO();
        // if game is won, declare winner
        if (this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Computer won, gg.");
            this.game.addPointToWinner();
            newGame();
            // if game is full and not won, declare tie
        } else if (this.game.isFull() && !this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText("Tie, gf.");
            newGame();
        }
        this.game.getFrame().score.setText(this.game.getWinsX() + "  " + this.game.getWinsO());
    }

    /**
     * Creates two random integers(0,1 or 2) and paints a cell representing
     * those.
     */
    private void paintRandomCellWithO() {
        int randomX;
        int randomY;
        while (true) {
            randomX = randomizeZeroToTwo();
            randomY = randomizeZeroToTwo();
            if (this.game.getCells()[randomX][randomY].getToken() == ' ') {
                this.game.getCells()[randomX][randomY].setToken('O');
                break;
            }
        }
    }

    public void newGame() {
        this.game.nullifyGameBoard();
    }

    /**
     * Creates random integer(0,1 or 2).
     *
     * @return 0, 1 or 2.
     */
    public int randomizeZeroToTwo() {
        Double randomD;
        randomD = Math.random();
        if (randomD < 0.33) {
            return 0;
        }
        if (randomD < 0.66) {
            return 1;
        } else {
            return 2;
        }
    }

}
