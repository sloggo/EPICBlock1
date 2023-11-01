package questiongame;
import java.util.Arrays;
//importing scanner package
import java.util.Scanner;
import org.bson.Document;


public class Main {
    
    public static void main(String[] args){
        Question[] Questions = {
            //Discrete Maths questions 74
            //Novice
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Let A = {1,2,3} and B = {3,4,5}. Find A u B", '4', new String[]{"{1,2,3,4,5}", "{1,2}", "{4,5}", "{3}"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Determine the truth value of the statement: (P ^ Q) v (¬P ^ Q) when P = True and Q =False", '2', new String[]{"True", "False",}),
            //Intermediate
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.INTERMEDIATE, "- Find the truth value of the statement: (P ^ Q) v (¬P ^ R) when P = True, Q = False, and R = True", '2', new String[]{"True", "False"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.INTERMEDIATE, "Find the walks of length two from a to a in the following matrix :\n a b c \n ---\n a | 1 0 1 \n b | 0 1 0 \n c | 1 0 1", '1', new String[]{"2", "0", "1", "4"}),
            //Expert
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.EXPERT, "-\tOn the fabled Island of Knights and Knaves, we meet three people, A, B, and C, one of whom is a knight, one a knave, and one a spy. The knight always tells the truth, the knave always lies, and the spy can either lie or tell the truth.\r\n" + //
                    "A says: \"C is a knave.\"\r\n" + //
                    "B says: \"A is a knight.\"\r\n" + //
                    "C says: \"I am the spy.\"\r\n" + //
                    "Who is the knight, who is the knave, and who is the spy?\r\n" + //
                    "", '4', new String[]{"A: Knight, B:Knave, C:Spy", "A:Spy, B:Knight, C:Knave", "A:Knave, B:Spy, C:Knight", "A:Knight, B:Spy, C:Knave"}),
            //need to insert matrix image in question on next line
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.EXPERT, "A system can take one of three states 1, 2, or 3. The system will change its status each second. The probability that a system will change from one state to another is given using the following adjacency matrix: ", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Computer Science
            //Novice
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.NOVICE, "-\tExplain what is meant by a Backus Naur Form", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.NOVICE, "-\tWhat does the term BDD stand for?", '4', new String[]{"Bernhard Description Diagram", "Braunt Design Diagram", "Backus Definition Diagram", "Boolean Decision Diagram"}),
            //Intermediate
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.INTERMEDIATE, "-\tWhat are the suprema and infima of this set? A = {1,2,3,4}", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.INTERMEDIATE, "-\tWhich of the following is an example of commutativity ", '1', new String[]{"A n B = B n A", "A u B = A n B", "A u(A n B) = A n B", "A'B = A u B"}),
            //Expert
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.EXPERT, "-\tWhat does ‘reductio ad absurdum’ mean ", '4', new String[]{"Constructive Proof", "Proof by cases", "Proof by Induction", "Proof by Contradiction"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.EXPERT, "-\tWhich of the following is a predicate", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Computer Organisation
            //Novice
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.NOVICE, "-\tOut of registers and the cache in a computer, which of the two is located inside the CPU.", '2', new String[]{"Cache", "Registers", "Both", "Neither"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.NOVICE, "-\tWhich of the below best describes the Von Neumann bottleneck", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Intermediate
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.INTERMEDIATE, "-\tConvert the binary number 1101 to decimal", '3', new String[]{"33", "3", "13", "53"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.INTERMEDIATE, "-\tWhich of the below are NOT found in the original Von Neumann machine ", '1', new String[]{"Audio Processor", "Memory", "Control Unit", "Arithmetic logic unit"}),
            //Expert
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.EXPERT, "-\tWhat is Moores law for CPU chips", '2', new String[]{"the number of transistors on a microchip doubles approximately every year", 
            "The number of transistors on a microchip doubles approximately every two years", "The number of registers in a CPU doubles approximately every two years", "The RAM doubles in a computer approximately every two years"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.EXPERT, "Convert the hexadecimal number 2A3F to binary", '4', new String[]{"1010101010101010", "0001011101000110", "1000111011101101", "1010001001111111"}),
        };
        
        User user = accountController.menu();
        System.out.println(user.username);
        commandLineMenu.gameModeMenu(Questions, user);
    }  


}