/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Frame;

/**
 *
 * @author lalex
 */
//logic for single player
public class SinglePlayerGame {
    private char whoseTurn = 'X';
    private Frame frame;
    public SinglePlayerGame(){
    frame = new Frame();
    
    }   

    public void setWhoseTurn(char whoseTurn) {
        if (whoseTurn == 'X' || whoseTurn == 'Y'){
            this.whoseTurn = whoseTurn;
        }
    }

    public char getWhoseTurn() {
        return whoseTurn;
    }
    public void swapTurns(){
        if (this.whoseTurn == 'X'){
            this.whoseTurn = 'Y'; 
        } else {
            this.whoseTurn = 'X';
        }
    }
    

}
