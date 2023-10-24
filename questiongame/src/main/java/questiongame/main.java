package questiongame;
import java.util.Arrays;
//importing scanner package
import java.util.Scanner;
import org.bson.Document;


public class Main {
    
    public static void main(String[] args){
        Question[] Questions = {
            //Discrete Maths questions
            //Novice
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Define a set A = {1,2,3}. List all the subsets of set A.", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Determine the truth value of the statement: (P ^ Q) v (¬P ^ Q) when P = True and Q =False", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Intermediate
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.INTERMEDIATE, "- Find the truth value of the statement: (P ^ Q) v (¬P ^ R) when P = True, Q = False, and R = True", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.INTERMEDIATE, "Prove that if a is an even integer and b is an odd integer, then ab is even.", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Expert
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.EXPERT, "-\tOn the fabled Island of Knights and Knaves, we meet three people, A, B, and C, one of whom is a knight, one a knave, and one a spy. The knight always tells the truth, the knave always lies, and the spy can either lie or tell the truth.\r\n" + //
                    "A says: \"C is a knave.\"\r\n" + //
                    "B says: \"A is a knight.\"\r\n" + //
                    "C says: \"I am the spy.\"\r\n" + //
                    "Who is the knight, who the knave, and who the spy?\r\n" + //
                    "", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //need to insert matrix image in question on next line
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.EXPERT, "A system can take one of three states 1, 2, or 3. The system will change its status each second. The probability that a system will change from one state to another is given using the following adjacency matrix: ", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Computer Science
            //Novice
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.NOVICE, "-\tExplain what is meant by a Backus Naur Form", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.NOVICE, "-\tWhat does the term BDD stand for?", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Intermediate
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.INTERMEDIATE, "-\tWhat are the suprema and infima of this set? A = {1,2,3,4}", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.INTERMEDIATE, "-\tSelect the Boolean connective below (AND, OR, NOT)", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Expert
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.EXPERT, "-\tWhich duo created ADD-Lib (Frederick Gossen + Tiziana Margaria)", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPSCIFOUND, questiongame.difficulty.EXPERT, "-\tWhat is a predicate", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Computer Organisation
            //Novice
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.NOVICE, "-\tWhich of the below is a chip manufacturer", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.NOVICE, "-\tWhat process is missing from the following cycle: Fetch, ____, Execute.", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Intermediate
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.INTERMEDIATE, "-\tWhich of the below best describes the Von Neumann bottleneck", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.INTERMEDIATE, "-\tWhat is Moores law for CPU chips.", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            //Expert
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.EXPERT, "-\tWhich of the below are NOT found in the original Von Neumann machine", 'a', new String[]{"opta", "optb", "optc", "optd"}),
            new Question(questiongame.topic.COMPORG, questiongame.difficulty.EXPERT, "Convert the hexadecimal number 2A3F to binary (ans = 1010001001111111)", 'a', new String[]{"opta", "optb", "optc", "optd"}),
        };
        
        Document user = accountController.menu();
        int[] array = {12,23,54,654,765,34,34,546,45,2,34,46,543,432,434};
        score.meanCalculator(array);
        score.medianCalculator(array);
        score.standardDeviation(array);
    }  


}