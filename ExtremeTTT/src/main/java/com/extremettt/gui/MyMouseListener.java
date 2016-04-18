/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 * Mouse Listener, what to do when clicking mouse.
 * @author lalex
 */
public class MyMouseListener extends MouseAdapter {
    private TwoPlayerGame game;
    private char whoseTurn;
    private char token;
    private Cell cell;
    private JLabel jlbl;
    public MyMouseListener(TwoPlayerGame game, Cell cell) {
        this.game = game;
        this.cell = cell;
        this.token = cell.getToken();
        whoseTurn = game.getWhoseTurn();
    }
    /**
     * What to do when clicking a cell
     * @param e Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //checks if game is full
        if (game.isFull()) {
            return;
        }
        //if cell doesn't have a token and its someones turn, sets token to cell
        if (this.token == ' ' && whoseTurn != ' ') {
            this.cell.setToken(whoseTurn);
        }
        
        //if game is won, declare winner
        if (game.isWon()) {
            //jlbl.setText(whoseTurn + " won, game over");
            
        //if game is full, but game is not won, declare tie
        } else if (game.isFull() && !game.isWon()) {
                   //jlbl.setText("Tie");
        } else {
            game.swapTurns();
            whoseTurn = game.getWhoseTurn();
            //jlbl.setText(whoseTurn + "'s turn.");
        }
    }
}
