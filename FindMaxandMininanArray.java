package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class FindMaxandMininanArray {

    /**
     * Finds the maximum value in an integer array.
     *
     * @param arr the input array
     * @return the maximum value, or Integer.MIN_VALUE if array is empty
     */
    public static int findMax(int[] arr) {
        // Handle empty array case
        if (arr.length == 0) {
            System.out.println("Array is empty, no maximum.");
            return Integer.MIN_VALUE; // Or throw exception
        }

        int max = arr[0]; // Assume first element is the maximum
        // Iterate from the second element (index 1) to the end
        for (int i = 1; i < arr.length; i++) {
            // If current element is greater than current max, update max
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum value in an integer array.
     *
     * @param arr the input array
     * @return the minimum value, or Integer.MAX_VALUE if array is empty
     */
    public static int findMin(int[] arr) {
        // Handle empty array case
        if (arr.length == 0) {
            System.out.println("Array is empty, no minimum.");
            return Integer.MAX_VALUE; // Or throw exception
        }

        int min = arr[0]; // Assume first element is the minimum
        // Iterate from the second element (index 1) to the end
        for (int i = 1; i < arr.length; i++) {
            // If current element is smaller than current min, update min
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // Example array
        int[] numbers = {34, -22, 78, 5, 99, -1, 42};

        // Display the array
        System.out.print("Array elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and display maximum
        int max = findMax(numbers);
        System.out.println("Maximum value: " + max);

        // Find and display minimum
        int min = findMin(numbers);
        System.out.println("Minimum value: " + min);
    }
}
