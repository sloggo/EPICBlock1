package questiongame;
import org.bson.Document;

public class Main {
    public static void main(String[] args){
        Document user = accountController.menu();
        
        leaderboard.generateLeaderboard();
    }  

}