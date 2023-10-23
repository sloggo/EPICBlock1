package questiongame;

public class score{
    public static void main(String[] args){

    }
    public static void modeFinder(int[] userScores){
        int[] array = {12,23,54,654,765,34,34,546,45,2,34,46,543,432,434};
        // variables to store the mode and its frequency
        int mode = 0;
        int maxFrequency = 0;

        //iterate through the array to find the mode
        for(int i = 0; i < array.length; i++){
            int count = 0;
            for(int j = 0; j < array.length; j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
        if (count > maxFrequency){
            maxFrequency = count;
            mode = array[i];
        }
    }
}
    public static void median(){

}
    public static void standardDeviation(){

}
}