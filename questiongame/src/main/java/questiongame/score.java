package questiongame;

public class score{
    public static void main(String[] args){

    }
    public static void meanCalculator(int[] userScores){
        int[] numbers = {5, 2, 9, 1, 5, 6};

        // Calculate the sum of the numbers
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Calculate the mean
        double mean = (double) sum / numbers.length;

        // Print the mean
        System.out.println("Mean of the array: " + mean);
    }
    public static void medianCalculator(){

}
    public static void standardDeviation(){
        
}
}
