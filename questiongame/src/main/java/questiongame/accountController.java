package questiongame;

//importing java package to take user inputs
import java.util.Scanner;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//creating the main class
public class accountController {
    
    public static Document menu(){
        Scanner scanner = new Scanner(System.in);
        //offering the user the choice to sign up or login
        System.out.println("Enter 0 to sign up or enter 1 to Log in");
        int menuchoice = scanner.nextInt();
        if (menuchoice == 0){
        //calling in the 'signup' method    
            return signup(); // will return user object
        }else if (menuchoice == 1){
        //calling in the 'login' method
            return login(); // will return user object
        }else {
            System.out.println("Invalid input");
        }
        return null;

    }
    //method 'signup' created for first time users
    public static Document signup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String newUserName = scanner.nextLine();
        //printing an error if the user does not input anything for username or password
        if (newUserName == ""){
            System.out.println("Error. Please input a username.");
        }else {
            System.out.println("Choose a password: ");
            String newPassword = scanner.nextLine();

            if (newPassword == ""){
            System.out.println("Error. Please input a password.");
            }else {
                System.out.println("Signing Up...");

                return database.createUser(newUserName, newPassword); // creates new user
            }
        } 

        return null;

    }
    //method 'login' created for users that have already signed up 
    public static Document login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        if (username == ""){
            System.out.println("Error. Please enter your username");
        }else {
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            if (password == ""){
                System.out.println("Error. Please enter your password");
            }else {
                System.out.print("Logging in...");
                return database.logIn(username, password); // logs into existing user
            }
        }
        return null;
    }
}
