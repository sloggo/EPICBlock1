package questiongame;

import java.util.Scanner;

import org.bson.Document;

public class commandLineMenu {

    public static Document gameModeMenu(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a game mode: Enter 1 for Random Quiz , 2 for Difficulty Based Quiz, or 3 for Timed Quiz");
        int gameModeChoice = scanner.nextInt();
        if (gameModeChoice == 1){
            return null;
        }else if (gameModeChoice == 2){
            return null;
        }else if (gameModeChoice == 3){
            return null;
        } else {
            System.out.println("Invalid input");
        }
        return null;
    }

}