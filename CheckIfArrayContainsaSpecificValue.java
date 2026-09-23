package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class CheckIfArrayContainsaSpecificValue {

    // Method to check if array contains a specific value
    public static boolean contains(int[] arr, int target) {
        // Iterate through each element
        for (int value : arr) {
            // If found, return true immediately
            if (value == target) {
                return true;
            }
        }
        // Value not found after full traversal
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int searchValue = 30;

        // Check and display result
        boolean result = contains(numbers, searchValue);
        System.out.println("Array contains " + searchValue + ": " + result);
    }
}
