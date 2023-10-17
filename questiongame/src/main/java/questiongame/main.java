package questiongame;
import org.bson.Document;

public class Main {
    public static void Main(String[] args){
        Document user = accountController.menu();
        System.out.println(user.toJson());
    }  

}