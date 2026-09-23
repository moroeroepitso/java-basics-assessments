package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class CalculateAverageofArrayElements {

    // Method to calculate average of array elements
    public static double calculateAverage(int[] arr) {
        // Handle empty array case
        if (arr.length == 0) {
            return 0.0;
        }

        int sum = 0;
        // Sum all elements
        for (int value : arr) {
            sum += value;
        }

        // Return average as double for decimal precision
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        // Example array
        int[] numbers = {10, 20, 30, 40, 50};

        // Calculate and display average
        double avg = calculateAverage(numbers);
        System.out.println("Average of array: " + avg);
    }
}
