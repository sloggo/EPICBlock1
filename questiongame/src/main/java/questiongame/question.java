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
        new Question(topic.DISCMATHS, difficulty.NOVICE, "test", 'a', new String[]{"opta", "optb"}),
        new Question(topic.DISCMATHS, difficulty.NOVICE, "test", 'a', new String[]{"opta", "optb"})
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
        System.out.println(sortedQuestions.toString());
        return sortedQuestions;
    }
}

