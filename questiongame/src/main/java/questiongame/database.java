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

    public static Document createUser(String usernameToCreate, String passwordToCreate){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        Bson usernameFilter = Filters.eq("username", usernameToCreate);

        int score = 0;

        ObjectId newUserId = new ObjectId();

        Document newUser = new Document()
                .append("userId", newUserId)
                .append("username", usernameToCreate)
                .append("password", passwordToCreate)
                .append("score", score);

        try{usersCollection.find(usernameFilter).first();
            System.out.println("ERROR: User already exists in database! Try a different username.");
            return null;
        } catch(Exception e){
            usersCollection.insertOne( newUser );
            System.out.println("Signed up!");
            return newUser;
        }
    }

    public static Document logIn(String user, String pass){
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
            System.out.println("Logged in!");
            userId = doc.get("_id").toString();
            return doc;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
        
    }
}
