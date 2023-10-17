package questiongame;

import java.util.Arrays;

public class Question {
    topic topic;
    difficulty difficulty;
    String question;
    char answer;
    String[] options;

    public Question(topic topic, difficulty difficulty, String question, char answer, String[] options){
        this.topic = topic;
        this.difficulty = difficulty;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    Question[] Questions = {
        //Discrete Maths questions
        //Novice
        new Question(topic.DISCMATHS, difficulty.NOVICE, "Define a set A = {1,2,3}. List all the subsets of set A.", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "Determine the truth value of the statement: (P ^ Q) v (¬P ^ Q) when P = True and Q =False", 'a', new String[]{"opta", "optb"}),
        //Intermediate
        new Question(topic.DISCMATHS, difficulty.NOVICE, "- Find the truth value of the statement: (P ^ Q) v (¬P ^ R) when P = True, Q = False, and R = True", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "Prove that if a is an even integer and b is an odd integer, then ab is even.", 'a', new String[]{"opta", "optb"}),
        //Expert
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tOn the fabled Island of Knights and Knaves, we meet three people, A, B, and C, one of whom is a knight, one a knave, and one a spy. The knight always tells the truth, the knave always lies, and the spy can either lie or tell the truth.\r\n" + //
                "A says: \"C is a knave.\"\r\n" + //
                "B says: \"A is a knight.\"\r\n" + //
                "C says: \"I am the spy.\"\r\n" + //
                "Who is the knight, who the knave, and who the spy?\r\n" + //
                "", 'a', new String[]{"opta", "optb"}),
        //need to insert matrix image in question on next line
        new Question(topic.DISCMATHS, difficulty.NOVICE, "A system can take one of three states 1, 2, or 3. The system will change its status each second. The probability that a system will change from one state to another is given using the following adjacency matrix: ", 'a', new String[]{"opta", "optb"}),
        //Computer Science
        //Novice
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tExplain what is meant by a Backus Naur Form", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhat does the term BDD stand for?", 'a', new String[]{"opta", "optb"}),
        //Intermediate
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhat are the suprema and infima of this set? A = {1,2,3,4}", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tSelect the Boolean connective below (AND, OR, NOT)", 'a', new String[]{"opta", "optb"}),
        //Expert
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhich duo created ADD-Lib (Frederick Gossen + Tiziana Margaria)", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhat is a predicate", 'a', new String[]{"opta", "optb"}),
        //Computer Organisation
        //Novice
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhich of the below is a chip manufacturer", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhat process is missing from the following cycle: Fetch, ____, Execute.", 'a', new String[]{"opta", "optb"}),
        //Intermediate
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhich of the below best describes the Von Neumann bottleneck", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhat is Moores law for CPU chips.", 'a', new String[]{"opta", "optb"}),
        //Expert
        new Question(topic.DISCMATHS, difficulty.NOVICE, "-\tWhich of the below are NOT found in the original Von Neumann machine", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "Convert the hexadecimal number 2A3F to binary (ans = 1010001001111111)", 'a', new String[]{"opta", "optb"}),
    };

    public Question[] getAllQuestions(){
        return Questions;
    }

    public Question[] fetchSpecificQuestions(topic topic, difficulty difficulty){
        Question[] sortedQuestions = {};
        for(int i=0; i<Questions.length; i++){
            if(Questions[i].topic == topic && Questions[i].difficulty == difficulty){
                sortedQuestions = Arrays.copyOf(sortedQuestions, sortedQuestions.length + 1);
                sortedQuestions[sortedQuestions.length - 1] = Questions[i];
            } 
        }
<<<<<<< HEAD
        System.out.println(sortedQuestions.toString());
=======
        System.out.println(sortedQuestions.toString())
>>>>>>> 9b5b3ef75c0ab652803ded2c7691d5270bd344ff
        return sortedQuestions;
    }
}

