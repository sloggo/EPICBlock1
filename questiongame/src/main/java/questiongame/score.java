package questiongame;
import java.util.Arrays;
public class score{
    public static void main(String[] args){

    }
    public static void meanCalculator(int[] userScores){
        int[] numbers = {5, 2, 9, 1, 5, 6};

        // Calculating the sum of the numbers
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Calculating the mean
        double mean = (double) sum / numbers.length;

        // Printing the mean
        System.out.println("Mean of the array: " + mean);
    }
    public static void medianCalculator(int[] userScores){
        int[] integers = {5, 2, 9, 1, 5, 6};
        Arrays.sort(integers);

        double median;
        int length = userScores.length;
        if (length % 2 == 0) {
            // If the length is even, average the middle two elements
            median = (double) (userScores[length / 2 - 1] + userScores[length / 2]) / 2;
        } else {
            // If the length is odd, pick the middle element
            median = userScores[length / 2];
        }
        // Print the median
        System.out.println("Median of the array: " + median);
}
    public static void standardDeviation(){
        
}
}
