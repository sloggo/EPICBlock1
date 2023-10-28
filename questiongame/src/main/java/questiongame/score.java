package questiongame;
import java.util.Arrays;
public class score{

    public static double meanCalculator(int[] userScores){

        // Calculating the sum of the numbers
        int sum = 0;
        for (int number : userScores) {
            sum += number;
        }

        // Calculating the mean
        double mean = (double) sum / userScores.length;

        // Printing the mean
        System.out.println("Mean of the array: " + mean);
        return mean;
    }
    public static void medianCalculator(int[] userScores){
        Arrays.sort(userScores);

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
    public static void standardDeviation(int[] userScores){
        //Calculating the variance
        double variance = 0;
        double mean = meanCalculator(userScores);
        for (int number : userScores) {
            variance += Math.pow(number - mean, 2);
        }
        variance /= userScores.length;

        // Step 3: Calculate the standard deviation (square root of the variance)
        double standardDeviation = Math.sqrt(variance);

        // Print the standard deviation
        System.out.println("Standard Deviation of the array: " + standardDeviation);
    }

    public static void updateScore(User user, int increase){
        user.score += increase;
        database.updateUser(user);
    }
}
