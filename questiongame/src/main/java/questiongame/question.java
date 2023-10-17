package questiongame;

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
        new Question(topic.DISCMATHS, difficulty.NOVICE, "test", 'a', new String[]{"opta", "optb"})
    };
}

