package questiongame;
import org.bson.Document;

public class Main {
    public static void main(String[] args){
        Document user = accountController.menu();

        Question questionInstance = new Question(topic.DISCMATHS, difficulty.NOVICE, "test", 'a', new String[]{"opta", "optb"});
        questionInstance.fetchSpecificQuestions(topic.COMPSCIFOUND, difficulty.NOVICE);
    }  

}