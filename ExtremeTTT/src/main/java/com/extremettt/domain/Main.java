package com.extremettt.domain;

import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;
import java.util.Scanner;
/**
 * Main Class
 */
public class Main {

    public static void main(String[] args) {
        Start start = new Start();
        start.startGame(start.singleOrTwo());
    }
}

