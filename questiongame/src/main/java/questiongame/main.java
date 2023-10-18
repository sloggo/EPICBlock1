package questiongame;
import java.util.Arrays;
import java.util.Scanner;
import org.bson.Document;

public class Main {
    
    public static void main(String[] args){
        Question[] Questions = {
            //Discrete Maths questions
            //Novice
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Define a set A = {1,2,3}. List all the subsets of set A.", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Determine the truth value of the statement: (P ^ Q) v (¬P ^ Q) when P = True and Q =False", 'a', new String[]{"opta", "optb"}),
            //Intermediate
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "- Find the truth value of the statement: (P ^ Q) v (¬P ^ R) when P = True, Q = False, and R = True", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Prove that if a is an even integer and b is an odd integer, then ab is even.", 'a', new String[]{"opta", "optb"}),
            //Expert
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tOn the fabled Island of Knights and Knaves, we meet three people, A, B, and C, one of whom is a knight, one a knave, and one a spy. The knight always tells the truth, the knave always lies, and the spy can either lie or tell the truth.\r\n" + //
                    "A says: \"C is a knave.\"\r\n" + //
                    "B says: \"A is a knight.\"\r\n" + //
                    "C says: \"I am the spy.\"\r\n" + //
                    "Who is the knight, who the knave, and who the spy?\r\n" + //
                    "", 'a', new String[]{"opta", "optb"}),
            //need to insert matrix image in question on next linellllllllllllllllllllllllllllllllllllllllllllllllllllllll
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "A system can take one of three states 1, 2, or 3. The system will change its status each second. The probability that a system will change from one state to another is given using the following adjacency matrix: ", 'a', new String[]{"opta", "optb"}),
            //Computer Science
            //Novice
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tExplain what is meant by a Backus Naur Form", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhat does the term BDD stand for?", 'a', new String[]{"opta", "optb"}),
            //Intermediate
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhat are the suprema and infima of this set? A = {1,2,3,4}", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tSelect the Boolean connective below (AND, OR, NOT)", 'a', new String[]{"opta", "optb"}),
            //Expert
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhich duo created ADD-Lib (Frederick Gossen + Tiziana Margaria)", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhat is a predicate", 'a', new String[]{"opta", "optb"}),
            //Computer Organisation
            //Novice
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.INTERMEDIATE, "-\tWhich of the below is a chip manufacturer", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhat process is missing from the following cycle: Fetch, ____, Execute.", 'a', new String[]{"opta", "optb"}),
            //Intermediate
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhich of the below best describes the Von Neumann bottleneck", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhat is Moores law for CPU chips.", 'a', new String[]{"opta", "optb"}),
            //Expert
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "-\tWhich of the below are NOT found in the original Von Neumann machine", 'a', new String[]{"opta", "optb"}),
            new Question(questiongame.topic.DISCMATHS, questiongame.difficulty.NOVICE, "Convert the hexadecimal number 2A3F to binary (ans = 1010001001111111)", 'a', new String[]{"opta", "optb"}),
        };

        Document user = accountController.menu();

        difficultyMode(Questions);
    }  


    public static Question[] fetchSpecificQuestions(topic topic, difficulty difficulty, Question[] questions){
        Question[] sortedQuestions = {};
        for(int i=0; i<questions.length; i++){
            if(topic != null && difficulty != null){ // if searching by both
                if(questions[i].topic == topic && questions[i].difficulty == difficulty){
                    sortedQuestions = Arrays.copyOf(sortedQuestions, sortedQuestions.length + 1);
                    sortedQuestions[sortedQuestions.length - 1] = questions[i];
                } 
            } else if(topic == null){ // if searching by difficulty only
                if(questions[i].difficulty == difficulty){
                    sortedQuestions = Arrays.copyOf(sortedQuestions, sortedQuestions.length + 1);
                    sortedQuestions[sortedQuestions.length - 1] = questions[i];
                } 
            } else if(difficulty == null){ // if searching by topic only
                if(questions[i].topic == topic){
                    sortedQuestions = Arrays.copyOf(sortedQuestions, sortedQuestions.length + 1);
                    sortedQuestions[sortedQuestions.length - 1] = questions[i];
                } 
            }
            
        }
        System.out.println(sortedQuestions.toString());
        return sortedQuestions;
    }

    public static void difficultyMode(Question[] questions){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to difficulty mode!");

        System.out.println("1 - Novice | 2 - Intermediate | 3 - Expert");

        int input = scanner.nextInt();
        questiongame.difficulty difficultySelection = null;
        switch(input){ // translate input to a difficulty selection
            case(1):
                difficultySelection = questiongame.difficulty.NOVICE; 
                break;
            case(2):
                difficultySelection = questiongame.difficulty.INTERMEDIATE;
                break;
            case(3):
                difficultySelection = questiongame.difficulty.EXPERT;
        }

        Question[] sortedQ = fetchSpecificQuestions(null, difficultySelection, questions);

        for(Question q : sortedQ){ // loop through selected questions
            System.out.println(q.question);
        }
    }

}