/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

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
    private Frame frame;
    public MyMouseListener(TwoPlayerGame game, Cell cell) {
        this.game = game;
        this.cell = cell;
        this.token = cell.getToken();
        this.whoseTurn = game.getWhoseTurn();
    }
    /**
     * What to do when clicking a cell
     * @param e Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        this.whoseTurn = this.game.getWhoseTurn();
        //checks if game is full or won before setting any tokens
        if (this.game.isFull() || this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText(this.whoseTurn + " won, game is already over");
            return;
        }
        //if cell doesn't have a token and its someones turn, sets token to cell
        if (this.cell.getToken() == ' ' && this.whoseTurn != ' ') {
            this.cell.setToken(whoseTurn);
        }
        
        //if game is won, declare winner
        if (this.game.isWon()) {
            this.game.getFrame().jlblStatus.setText(this.whoseTurn + " won, game over");
            this.whoseTurn = ' ';
     
        } 
        //if game is full, but game is not won, declare tie 
        else if (this.game.isFull()) {
                   this.game.getFrame().jlblStatus.setText("tie!");
                   this.whoseTurn = ' ';
        }
        //if game is not won nor full, swap turns and print whose turn it is
        if (!this.game.isWon() && !this.game.isFull()) {
            this.game.swapTurns();
            this.whoseTurn = this.game.getWhoseTurn();
            this.game.getFrame().jlblStatus.setText(this.whoseTurn + "'s turn");
        }
    }
}
