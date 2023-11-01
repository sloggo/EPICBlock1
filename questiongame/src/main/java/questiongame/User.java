package questiongame;

import org.bson.types.ObjectId;
//user class
public class User {
    String userId;
    String username;
    String password;
    int score;

    public User(String userId, String username, String password, int score){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.score = score;
    }
}
