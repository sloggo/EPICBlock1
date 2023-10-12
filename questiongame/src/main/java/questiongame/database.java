package questiongame;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class database {
    
    public static void connect(){
        String uri = "mongodb+srv://sloggo:sloggo@questiongame.ivpo6ff.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            System.out.println("sauce");
        }
    }
}
