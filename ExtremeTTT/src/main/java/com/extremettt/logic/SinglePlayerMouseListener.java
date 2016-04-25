/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.MyMouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author lalex
 */
public class SinglePlayerMouseListener extends MyMouseListener {

    private Cell cell;

    public SinglePlayerMouseListener(TwoPlayerGame game, Cell cell) {
        super(game, cell);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
