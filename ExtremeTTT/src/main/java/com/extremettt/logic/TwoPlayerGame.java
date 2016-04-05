/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.logic;

import com.extremettt.gui.Cell;
import com.extremettt.gui.Frame;

/**
 *
 * @author lalex
 */
//The logic for multiplayer game
public class TwoPlayerGame {
    private Cell[][] cells;
    private char whoseTurn = 'X';
    private Frame frame;
    
    public TwoPlayerGame() {
      frame = new Frame();
      Cell[][] cells = frame.getCells();
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
    
    //checks if game is won by 3 diagonally
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
    
    //checks every victory possibility
    public boolean isWon(char token){
        if(isWonRows(token) || isWonColumns(token) || isWonDiagonal(token)){
            return true;
        }
        return false;
    }
}

