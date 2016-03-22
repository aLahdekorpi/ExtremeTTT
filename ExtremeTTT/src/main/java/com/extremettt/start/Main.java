
package com.extremettt.start;
import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;


import java.util.Scanner;

public class Main {
    //Starts the game
    public static void main(String[] args) {
        startGame();
        
        
    }
    //Asks the user if multiplayer
    public static void startGame(){
        System.out.println("Single player or Two player game?(S / T)");
        boolean isMultiplayer = true;
        Scanner s = new Scanner(System.in);
        String c = s.nextLine();
        if(c.equals("S")){
            isMultiplayer = false;
        }
        
        if(isMultiplayer == true){
            new TwoPlayerGame();
            System.out.println("two player");
        } else {
            new SinglePlayerGame();
            System.out.println("single player");
        }
    }
    
}
