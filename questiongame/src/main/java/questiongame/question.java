package questiongame;

public class question {
    topic topic;
    difficulty difficulty;
    String question;
    char answer;
    String[] options;

    public question(topic topic, difficulty difficulty, String question, char answer, String[] options){
        this.topic = topic;
        this.difficulty = difficulty;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
}
