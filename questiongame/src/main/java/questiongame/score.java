package questiongame;

public class score{
    public static void main(String[] args){

    }
    public static void modeFinder(int[] userScores){
        // variables to store the mode and its frequency
        int mode = 0;
        int maxFrequency = 0;

        //iterate through the userScores to find the mode
        for(int i = 0; i < userScores.length; i++){
            int count = 0;
            for(int j = 0; j < userScores.length; j++){
                if(userScores[i] == userScores[j]){
                    count++;
                }
            }
        if (count > maxFrequency){
            maxFrequency = count;
            mode = userScores[i];
        }
        System.out.println("Mode of the array: " + mode);
    }
}
    public static void median(){

}
    public static void standardDeviation(){

}
}