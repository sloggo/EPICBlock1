package questiongame;

import java.util.Scanner;

import org.bson.Document;

public class commandLineMenu {

    public static void gameModeMenu(Question[] Questions){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a game mode: Enter 1 for Random Quiz , 2 for Difficulty Based Quiz, or 3 for Sudden Death");
        int gameModeChoice = scanner.nextInt();
        if (gameModeChoice == 1){
            modeController.randomMode(Questions);
        }else if (gameModeChoice == 2){
            modeController.difficultyMode(Questions);
        }else if (gameModeChoice == 3){
            modeController.suddenDeath(Questions);
        } else {
            System.out.println("Invalid input");
        }
    }

}