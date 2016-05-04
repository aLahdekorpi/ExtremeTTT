/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.BoardSweeper;
import com.extremettt.logic.FullChecker;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.extremettt.logic.TwoPlayerGame;
import com.extremettt.logic.WinChecker;

/**
 * Mouse Listener, what to do when clicking mouse.
 *
 * @author lalex
 */
public class MyMouseListener extends MouseAdapter {

    private TwoPlayerGame game;
    private char whoseTurn;
    private char token;
    private Cell cell;
    private WinChecker winC;
    private FullChecker fullC;
    private BoardSweeper sweeper;

    /**
     * Constructor.
     *
     * @param game Game
     * @param cell Cell
     */
    public MyMouseListener(TwoPlayerGame game, Cell cell) {
        this.game = game;
        this.cell = cell;
        this.token = cell.getToken();
        this.whoseTurn = game.getWhoseTurn();
        this.fullC = new FullChecker(game);
        this.winC = new WinChecker(game);
        this.sweeper = new BoardSweeper(game);
    }

    /**
     * What to do when clicking a cell.
     *
     * @param e Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.cell.getToken() != ' ') {
            return;
        }
        this.whoseTurn = this.game.getWhoseTurn();
        //checks if game is full or won before setting any tokens
        if (this.fullC.isFull() || this.winC.isWon()) {
            this.game.getFrame().jlblStatus.setText("Game is already over");
            return;
        }
        //if cell doesn't have a token and its someones turn, sets token to cell
        if (this.cell.getToken() == ' ' && this.whoseTurn != ' ') {
            this.cell.setToken(whoseTurn);
            //nextTurn();
        }

        //if game is won, declare winner
        if (this.winC.isWon()) {
            gameIsWonAfterClicked();
            //if game is full, but game is not won, declare tie 
        }
        if (this.fullC.isFull() && !this.winC.isWon()) {
            gameIsFullAfterClicked();
        }
        //if game is not won nor full, swap turns and print whose turn it is
        if (!this.winC.isWon() && !this.fullC.isFull()) {
            nextTurn();
        }
        this.game.getFrame().score.setText("X: " + this.game.getWinsX() + " O: " + this.game.getWinsO());
    }

    /**
     * Starts a new Game.
     */
    public void newGame() {
        this.sweeper.nullifyGameBoard();
    }

    /**
     * Declares winner, sets whoseTurn to ' ', disposes frame, starts a new
     * game.
     */
    public void gameIsWonAfterClicked() {
        this.game.addPointToWinner();
        newGame();
        this.game.getFrame().jlblStatus.setText(this.whoseTurn + " won, game over");
    }

    /**
     * Declares tie, sets whoseTurn to ' ', disposes frame, starts a new game.
     */
    public void gameIsFullAfterClicked() {
        this.game.getFrame().jlblStatus.setText("tie!");
        newGame();
    }

    /**
     * Swaps turns, sets whoseTurn to correct char, sets jlbl text to whose turn
     * is it.
     */
    public void nextTurn() {
        this.game.swapTurns();
        this.whoseTurn = this.game.getWhoseTurn();
        this.game.getFrame().jlblStatus.setText(this.whoseTurn + "'s turn");
    }
}
