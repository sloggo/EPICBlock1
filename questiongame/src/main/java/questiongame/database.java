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

        // Create separate filters for "username" and "password"
        Bson usernameFilter = Filters.eq("username", user);
        Bson passwordFilter = Filters.eq("password", pass);

        // Combine the filters using the Filters.and method
        Bson filter = Filters.and(usernameFilter, passwordFilter);
        String userId = "";
        try{Document doc = usersCollection.find(filter).first();
            System.out.println(doc.toJson());
            System.out.println("Logged in database");
            userId = doc.get("_id").toString();
        } catch(Exception e){
            System.out.println(e);
        }
        return userId;
    }
}
