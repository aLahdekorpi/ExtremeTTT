/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lalex
 */
public class MyMouseListener extends MouseAdapter {

    private boolean isMultiplayer;

    public MyMouseListener(boolean isMultiplayer) {
        this.isMultiplayer = isMultiplayer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public boolean getIfMultiplayer() {
        return this.isMultiplayer;
    }
}
