/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.domain.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Button listener, what to do when buttons are pressed.
 *
 * @author lalex
 */
public class ButtonListener implements ActionListener {

    private Start start;
    private JButton b;

    /**
     * Constructor.
     *
     * @param start Start, where this ButtonListener is created.
     */
    public ButtonListener(Start start) {
        this.start = start;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Two Players")) {
            this.start.startGame("T");
            this.start.getStartFrame().dispose();
        }
        if (e.getActionCommand().equals("Single Player")) {
            System.out.println("single has been clicked");
            this.start.startGame("S");
            this.start.getStartFrame().dispose();
        }
    }

}
