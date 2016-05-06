/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import com.extremettt.start.Start;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 * Frame for starting a game.
 *
 * @author lalex
 */
public class StartFrame extends JFrame {

    private Start start;

    /**
     * Constructor.
     *
     * @param start Start
     */
    public StartFrame(Start start) {
        this.start = start;
    }

    /**
     * Creates a Single Player button.
     */
    public void createButtonSingle() {
        JButton single = new JButton("Single Player");
        single.setBorder(new LineBorder(Color.yellow, 1));
        single.addActionListener(new ButtonListener(this.start));
        single.setPreferredSize(new Dimension(300, 100));
        add(single, BorderLayout.LINE_START);
    }

    /**
     * Creates a Two Players button.
     */
    public void createButtonTwo() {
        JButton two = new JButton("Two Players");
        two.setBorder(new LineBorder(Color.yellow, 1));
        two.addActionListener(new ButtonListener(this.start));
        two.setPreferredSize(new Dimension(300, 100));
        add(two, BorderLayout.LINE_END);
    }
}
