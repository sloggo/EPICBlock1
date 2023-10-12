package questiongame;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) throws Exception {
        database databaseController = new database();

        MongoDatabase mongoDB = databaseController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        System.out.println(usersCollection);
    }
}