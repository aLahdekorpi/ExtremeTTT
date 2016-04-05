/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author lalex
 */
public class Frame extends JFrame {

    //create the grid
    private Cell[][] cells = new Cell[3][3];

    public Cell[][] getCells() {
        return cells;
    }

    public char getWhoseTurn() {
        return whoseTurn;
    }
    JLabel jlblStatus = new JLabel("X's turn to play");
    private char whoseTurn = 'X';

    public Frame() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++){
           for (int j = 0; j < 3; j++){
               panel.add(cells[i][j] = new Cell());
           }
        }
        panel.setBorder(new LineBorder(Color.red, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));
 
        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
    }
    //checks if board is full
    public boolean isFull(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3;j++){
                if(cells[i][j].getToken() == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    //checks if game is won by 3 in a row
    public boolean isWonRows(char token){
        for (int i = 0; i < 3; i++){
           if ((cells[i][0].getToken() == token)
                   && (cells[i][1].getToken() == token)
                   && (cells[i][2].getToken() == token))
           {
               return true;
           }
        }
        return false;
    }
    //checks if game is won by 3 in a column
    public boolean isWonColumns(char token){
        for (int j = 0; j<3;j++){
            if ((cells[0][j].getToken() == token)
               && (cells[1][j].getToken() == token)
               && (cells[2][j].getToken() == token))
           {
               return true;
           }
        }
        return false;
    }
    public boolean isWonDiagonal(char token){
        if ((cells[0][0].getToken() == token)
            && (cells[1][1].getToken() == token)
            && (cells[2][2].getToken() == token))
           {
               return true;
           }
 
       if ((cells[0][2].getToken() == token)
               && (cells[1][1].getToken() == token)
               && (cells[2][0].getToken() == token))
           {
               return true;
           }
       return false;
    }
    public boolean isWon(char token){
        if(isWonRows(token) || isWonColumns(token) || isWonDiagonal(token)){
            return true;
        }
        return false;
    }
}

