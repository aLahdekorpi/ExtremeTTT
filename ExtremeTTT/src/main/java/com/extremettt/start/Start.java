/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.start;

import com.extremettt.gui.StartFrame;
import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 * Class to start the game.
 *
 * @author lalex
 *
 */
public class Start {

    private StartFrame startFrame;

    /**
     * Constructor, no parameters.
     */
    public Start() {
        this.startFrame = new StartFrame(Start.this);
        initializeStartFrame();

    }

    public StartFrame getStartFrame() {
        return startFrame;
    }

    /**
     * Starts a game depending on parameter.
     * <p>
     * prints "Single decided" if parameter is "S", prints "Two decided" if
     * parameter is "T", prints "Problem in parameter, if not "T" or "S".
     * </p>
     *
     * @param s String, should be "S" or "T"
     */
    public void startGame(String s) {
        if (s.equals("S")) {
            System.out.print("Single decided");
            SinglePlayerGame sGame = new SinglePlayerGame();
        } else if (s.equals("T")) {
            System.out.print("Two decided");
            TwoPlayerGame tGame = new TwoPlayerGame();
        } else {
            System.out.print("Problem in parameter");
        }
    }

    /**
     * Initializes the StartFrame.
     * <p>
     * Sets title, size, default close operation (Exit on close), location and
     * visible to startFrame Creates two buttons through methods
     * createButtonSingle, createButtonTwo.
     * </p>
     *
     */
    public void initializeStartFrame() {
        this.startFrame.setTitle("ExtremeTTT Start!");
        this.startFrame.setSize(600, 600);
        this.startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startFrame.createButtonSingle();
        this.startFrame.createButtonTwo();
        this.startFrame.setLocationRelativeTo(null);
        this.startFrame.setVisible(true);

    }

}
