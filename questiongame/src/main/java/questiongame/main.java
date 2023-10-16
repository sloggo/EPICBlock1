package questiongame;
import org.bson.Document;

public class main {
    public static void main(String[] args){
        Document user = login.menu();

        System.out.println(user.toJson());
    }
}
