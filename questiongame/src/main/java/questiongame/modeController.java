package questiongame;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class modeController {
//method for sorting through questions
    public static Question[] fetchSpecificQuestions(topic topic, difficulty difficulty, Question[] questions){
        //create questions array
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
//nethod for printing questions
    public static void printQuestion(Question question){
        System.out.println("------------------------------------------------------");
        System.out.println(question.question);
        System.out.println("");

            for(String ans: question.options){
                int index = Arrays.asList(question.options).indexOf(ans);
                System.out.println((index+1)+ ": "+ans+"\t");
            }
            System.out.println("");
    }
//varying difficulty mode method
    public static void difficultyMode(Question[] questions, User user){
        gameLogic.clearConsole();
        int correct = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to difficulty mode!");

        System.out.println("1 - Novice | 2 - Intermediate | 3 - Expert");

        int input = scanner.nextInt();
        scanner.nextLine();
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
        gameLogic.clearConsole();

        System.out.println(sortedQ.toString());

        for(Question q : sortedQ){ // loop through selected questions
            printQuestion(q);
            String ansString = scanner.nextLine();

            if(ansString.equals(q.answer)){
                System.out.println("Correct!\n");
                correct++;
            } else{
                System.out.println("Incorrect!\n");
            }
        }

        finishedQuiz(user, correct);
    }
//random mode method
    public static void randomMode(Question[] questions, User user){
        gameLogic.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Random Mode!");
        int correct = 0;

        for(int i = 0; i<6; i++){
            int questionLength = questions.length;
            Random random = new Random();
            int randomIndex = random.nextInt(questionLength);
            Question randomQ = questions[randomIndex];

            printQuestion(randomQ);
            String ansString = scanner.nextLine();

            if(ansString.equals(randomQ.answer)){
                System.out.println("Correct!\n");
                correct++;
            } else{
                System.out.println("Incorrect!\n");
            }
        }

            gameLogic.clearConsole();
            finishedQuiz(user, correct);
    }
//sudden death mode method
    public static void suddenDeath(Question[] questions, User user){
        gameLogic.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sudden Death Mode!");

        boolean alive = true;
        int round = 1;

        while(alive == true){
            int questionLength = questions.length;
            Random random = new Random();
            int randomIndex = random.nextInt(questionLength);
            Question randomQ = questions[randomIndex];

            printQuestion(randomQ);
            String ansString = scanner.nextLine();

            if(ansString.equals(randomQ.answer)){
                System.out.println("Correct!\n");
                round++;
            } else{
                System.out.println("Incorrect! You lasted " + round + " rounds.\n");
                alive = false;
            }
        }
        finishedQuiz(user, round);
    }
//when quiz finished, leaderboard is generated
    public static void finishedQuiz(User user, int increaseScore){
        score.updateScore(user, increaseScore);
        leaderboard.generateLeaderboard(increaseScore);
    }

}
