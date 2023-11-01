package questiongame;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class modeController {

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

    public static void printQuestion(Question question){
        System.out.println(question.question);
        System.out.println("");

            for(String ans: question.options){
                int index = Arrays.asList(question.options).indexOf(ans);
                System.out.println((index+1)+ ": "+ans+"\t");
            }
            System.out.println("");
    }

    public static void difficultyMode(Question[] questions, User user){
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for(Question q : sortedQ){ // loop through selected questions
            printQuestion(q);
            String ansString = scanner.nextLine();

            if(ansString == q.answer){
                System.out.println("Correct!");
                correct++;
            } else{
                System.out.println("Incorrect!");
                break;
            }
        }

        finishedQuiz(user, correct);
    }

    public static void randomMode(Question[] questions, User user){
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

            if(ansString == randomQ.answer){
                System.out.println("Correct!");
                correct++;
            } else{
                System.out.println("Incorrect!");
            }
        }
        
            System.out.print("\033[H\033[2J");
            System.out.flush();
            finishedQuiz(user, correct);
    }

    public static void suddenDeath(Question[] questions, User user){
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

            if(ansString == randomQ.answer){
                System.out.println("Correct!");
                round++;
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else{
                System.out.println("Incorrect! You lasted "+round+" rounds.");
                alive = false;
            }
        }
        finishedQuiz(user, round);
    }

    public static void finishedQuiz(User user, int increaseScore){
        score.updateScore(user, increaseScore);
        leaderboard.generateLeaderboard();
    }

}
