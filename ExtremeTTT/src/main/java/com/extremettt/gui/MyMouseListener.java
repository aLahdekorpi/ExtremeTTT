/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.logic.TwoPlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lalex
 */
public class MyMouseListener extends MouseAdapter {
    private TwoPlayerGame game;
    private char whoseTurn;
    public MyMouseListener(TwoPlayerGame game) {
        this.game = game;
        whoseTurn = game.getWhoseTurn();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(game.isFull()){
            return;
        }
        
    }
}
