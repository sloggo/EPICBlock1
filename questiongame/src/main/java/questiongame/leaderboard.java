package questiongame;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class leaderboard {
    public static void generateLeaderboard(){
        MongoCollection<Document> usersIterable = database.getAllUsers();

        // Convert the collection to an array
        List<Document> userList = new ArrayList<>();
        usersIterable.find().into(userList);

        // Convert the list to an array
        Document[] userArray = userList.toArray(new Document[userList.size()]);
        System.out.println(userArray);

        System.out.println("Username \t\t Score");

        for (Document user : userArray) {
            System.out.println(user.get("username") + " \t\t\t "+ user.get("score"));
        }
    }
}