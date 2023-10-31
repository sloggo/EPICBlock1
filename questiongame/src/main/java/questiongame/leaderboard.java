package questiongame;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class leaderboard {
    public static void generateLeaderboard(){
        List<Document> userArray = database.getAllUsers();

        // Convert the list to an array
        System.out.println(userArray);

        System.out.println("\tLEADERBOARD\n");
        System.out.println("Username \t\t Score");
        System.out.println("-----------------------------------");

        List<Integer> scores = new ArrayList<>();

        for (Document user : userArray) {
            System.out.println(user.get("username") + " \t\t\t "+ user.get("score"));
            scores.add(Integer.parseInt(user.get("score").toString()));
        }

        double mean = score.meanCalculator(scores);
        System.out.println("Mean score: "+mean);

        double median = score.medianCalculator(scores);
        System.out.println("Median score: "+median);

        double sd = score.standardDeviation(scores);
        System.out.println("Standard Deviation score: "+sd);
    }
    public static void getStatistics(){

    }
}