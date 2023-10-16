package questiongame;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class database {
    String uri = "mongodb+srv://sloggo:sloggo@questiongame.ivpo6ff.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);

    public static String createUser(String usernameToCreate, String passwordToCreate){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        int score = 0;

        ObjectId newUserId = new ObjectId();

        usersCollection.insertOne(new Document()
            .append("userId", newUserId)
            .append("username", usernameToCreate)
            .append("password", passwordToCreate)
            .append("score", score)
        );

        return newUserId.toString();
    }

    public static String logIn(String user, String pass){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        Bson filterUser = eq("username", user); 
        Bson filterPass = eq("password", pass);// look for a user with a matching username and pass

        Bson filter = Filters.and(filterUser, filterPass); 

        usersCollection.find(filter).map(doc -> { // if both user and pass match

            System.out.println(doc.toJson());
            System.out.println("Logged in database");
            System.out.println(doc.get("_id").toString());
            return "";
        });

        return "";
    }
}
