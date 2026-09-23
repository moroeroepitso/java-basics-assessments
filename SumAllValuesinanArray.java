package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class SumAllValuesinanArray {

    // Method to compute sum of all elements in an integer array
    public static int sumArray(int[] arr) {
        int sum = 0;
        // Iterate through each element and add to sum
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example array
        int[] numbers = {5, 10, 15, 20, 25};

        // Call sum method and print result
        int total = sumArray(numbers);
        System.out.println("Sum of array: " + total);
    }
}
