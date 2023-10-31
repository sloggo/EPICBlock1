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
import com.mongodb.client.model.ReplaceOptions;

public class database {
    String uri = "mongodb+srv://sloggo:sloggo@questiongame.ivpo6ff.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);

    public static User createUser(String usernameToCreate, String passwordToCreate){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        Bson usernameFilter = Filters.eq("username", usernameToCreate);

        try {
            Document existingUser = usersCollection.find(usernameFilter).first();
            if (existingUser != null) {
                System.out.println("ERROR: User already exists in database! Try a different username.");
                return null;
            } else {
                int score = 0;
                ObjectId newUserId = new ObjectId();
                Document newUser = new Document()
                        .append("userId", newUserId)
                        .append("username", usernameToCreate)
                        .append("password", passwordToCreate)
                        .append("score", score);
                usersCollection.insertOne(newUser);
                User newUserObj = new User(newUserId.toString(), usernameToCreate, passwordToCreate, score);
                System.out.println("Signed up!");
                return newUserObj;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static User logIn(String user, String pass){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        // Create separate filters for "username" and "password"
        Bson usernameFilter = Filters.eq("username", user);
        Bson passwordFilter = Filters.eq("password", pass);

        // Combine the filters using the Filters.and method
        Bson filter = Filters.and(usernameFilter, passwordFilter);
        String userId = "";
        try {
            Document doc = usersCollection.find(filter).first();
            if (doc != null) {
                System.out.println("Logged in!");
                User newUserObj = new User(doc.get("_id").toString(), doc.get("username").toString(), doc.get("password").toString(), Integer.parseInt(doc.get("score").toString()));
                return newUserObj;
            } else {
                System.out.println("User not found or incorrect credentials.");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }

    public static MongoCollection<Document> getAllUsers(){
        System.out.println("Getting all users...");
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        return usersCollection;
    }

    public static void updateUser(User user){
        database dBController = new database();
        MongoDatabase mongoDB = dBController.mongoClient.getDatabase("questionGame");
        MongoCollection<Document> usersCollection = mongoDB.getCollection("users");

        Bson usernameFilter = Filters.eq("username", user.username);

        Document newUser = new Document() // convert updated user back into a document to insert into mongodb again
                        .append("userId", new ObjectId(user.userId))
                        .append("username", user.username)
                        .append("password", user.password)
                        .append("score", user.score);

        ReplaceOptions opts = new ReplaceOptions().upsert(true);
        usersCollection.replaceOne(usernameFilter, newUser, opts);
    }
}
