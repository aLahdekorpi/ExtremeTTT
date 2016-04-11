/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extremettt.domain;

import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;
import java.util.Scanner;

/**
 *
 * @author lalex
 */
public class Start {
    public Start(){
    }
    //Starts a game depending on parameter
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
    //asks user if single or two, returns "S" or "T"
    public String singleOrTwo() {
        System.out.println("Single player or Two player game?(S / T)");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (!string.equals("S") || !string.equals("T")) {
            if (string.equals("S")) {
                return "S";
            } else if (string.equals("T")) {
                return "T";
            } else {
                System.out.println("not S nor T");
                string = scanner.nextLine();
            }
        }
        return "Well something went wrong";
    }
}
