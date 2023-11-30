package questiongame;

public class gameLogic {
//method for clearing the console
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
                System.out.flush();
    }
//Question function and log in loop 
    public static void startGame(){
        Question[] Questions = database.fetchQuestions();
        //login/signup prompt loop
        boolean loggedIn = false;

        while(!loggedIn){
            System.out.println("\n\nWELCOME TO QUIZWIZZ!");
            System.out.println("Copyright 2023 - KISS Solutions Plc");

            User user = accountController.menu();
            if(user != null){
                gameLogic.clearConsole();
                //clearing console
                System.out.println("Welcome "+user.username+"!");
                loggedIn = true;
                commandLineMenu.gameModeMenu(Questions, user);
            }
        }
    }
}
