
package com.extremettt.start;
import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(startGame() == false){
            System.out.println("Not S nor T");
        }    
    
        
        
    }
    //Starts a game, if correct input.
    public static boolean startGame(){
        System.out.println("Single player or Two player game?(S / T)");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if(string.equals("S")){
            SinglePlayerGame sGame = new SinglePlayerGame();
            System.out.println("single player");
            return true;
        } else if (string.equals("T")){
            TwoPlayerGame mGame = new TwoPlayerGame();
            System.out.println("two player");
            return true;
        }
    return false;
    }
}

