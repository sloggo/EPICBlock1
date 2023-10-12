package questiongame;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class database {
    String uri = "mongodb+srv://sloggo:sloggo@questiongame.ivpo6ff.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);

    public static String createUser(String usernameToCreate, String passwordToCreate){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        int[] scores = {};

        ObjectId newUserId = new ObjectId();

        usersCollection.insertOne(new Document()
            .append("userId", newUserId)
            .append("username", usernameToCreate)
            .append("password", passwordToCreate)
        );

        return newUserId.toString();
    }
}
