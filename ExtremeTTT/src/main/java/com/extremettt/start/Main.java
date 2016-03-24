
package com.extremettt.start;
import com.extremettt.logic.SinglePlayerGame;
import com.extremettt.logic.TwoPlayerGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame(singleOrTwo());   
        
    }
    //Starts a game
    public static void startGame(String s){
        if(s.equals("S")){
            SinglePlayerGame sGame = new SinglePlayerGame();
            System.out.print("Single decided");
        } else if(s.equals("T")){
            TwoPlayerGame tGame = new TwoPlayerGame();
            System.out.print("Two decided");
        } else {
            System.out.print("Problem in parameter");
        }
    }
    //Asks user if single or two, returns S or T
    public static String singleOrTwo(){
        System.out.println("Single player or Two player game?(S / T)");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (!string.equals("S") || !string.equals("T")){
            if(string.equals("S")){
                return "S";
            } else if (string.equals("T")){
                return "T";    
            }
            else{
                System.out.println("not S nor T");
                string = scanner.nextLine();
            }
        }
        return "meme";
    }
}

