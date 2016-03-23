
package com.extremettt.start;
import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;


import java.util.Scanner;

public class Main {
    //Starts the game
    public static void main(String[] args) {
        System.out.println("Single player or Two player game?(S / T)");
        boolean isMultiplayer = true;
        Scanner s = new Scanner(System.in);
        String c = s.nextLine();
        if(c.equals("S")){
            isMultiplayer = false;
        }
        
        if(isMultiplayer == true){
            TwoPlayerGame mGame = new TwoPlayerGame();
            System.out.println("two player");
        } else {
            SinglePlayerGame sGame = new SinglePlayerGame();
            System.out.println("single player");
        }
    
        
        
    }
    
    
}
