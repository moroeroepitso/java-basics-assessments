package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class FindIndexofanElementinanArray {

    // Method to find the index of a given target in an array
    // Returns the index of the first occurrence, or -1 if not found
    public static int findIndex(int[] arr, int target) {
        // Iterate through the array using indexed loop
        for (int i = 0; i < arr.length; i++) {
            // Check if current element matches target
            if (arr[i] == target) {
                return i; // Return the index immediately
            }
        }
        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int searchValue = 30;

        int index = findIndex(numbers, searchValue);
        if (index != -1) {
            System.out.println("Element " + searchValue + " found at index: " + index);
        } else {
            System.out.println("Element " + searchValue + " not found in the array.");
        }
    }
}
