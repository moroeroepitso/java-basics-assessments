package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class FindtheSecondLargestArrayElement {

    /**
     * Find the Second Largest Element in an Array.
     *
     * This program finds the second largest distinct integer in an array. If
     * there are duplicates, they are considered as one (the largest value might
     * repeat, but we want the second largest distinct value).
     *
     * Example: [3, 7, 7, 2, 8, 8, 5] → second largest = 7
     *
     * Edge cases: - If array has fewer than 2 distinct elements, return
     * Integer.MIN_VALUE or throw exception Finds the second largest distinct
     * element in an integer array.
     *
     * @param arr Input array (not null)
     * @return The second largest distinct value, or Integer.MIN_VALUE if not
     * possible
     */
    public static int findSecondLargest(int[] arr) {
        // Step 1: Validate input
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return Integer.MIN_VALUE; // sentinel value, or could throw exception
        }

        // Step 2: Initialize two variables
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Step 3: Single pass through the array
        for (int num : arr) {
            // If current number is greater than the current largest
            if (num > largest) {
                // The old largest becomes the second largest
                secondLargest = largest;
                largest = num;
            } // If current number is between largest and secondLargest (and not equal to largest)
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // Step 4: Check if a valid second largest was found
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements may be equal or array has only one distinct value).");
            return Integer.MIN_VALUE;
        }

        return secondLargest;
    }

    // --- Demonstration in main ---
    public static void main(String[] args) {
        // Test case 1: Normal case with duplicates
        int[] arr1 = {3, 7, 7, 2, 8, 8, 5};
        System.out.print("Array: ");
        printArray(arr1);
        int result1 = findSecondLargest(arr1);
        System.out.println("Second largest: " + result1);
        System.out.println();

        // Test case 2: Array with only two elements
        int[] arr2 = {10, 5};
        System.out.print("Array: ");
        printArray(arr2);
        System.out.println("Second largest: " + findSecondLargest(arr2));
        System.out.println();

        // Test case 3: All elements same
        int[] arr3 = {4, 4, 4, 4};
        System.out.print("Array: ");
        printArray(arr3);
        int result3 = findSecondLargest(arr3);
        System.out.println("Second largest: " + (result3 == Integer.MIN_VALUE ? "Not available" : result3));
        System.out.println();

        // Test case 4: Array with negative numbers
        int[] arr4 = {-5, -2, -8, -1, -3};
        System.out.print("Array: ");
        printArray(arr4);
        System.out.println("Second largest: " + findSecondLargest(arr4));
        System.out.println();

        // Test case 5: Edge case – less than two elements
        int[] arr5 = {42};
        System.out.print("Array: ");
        printArray(arr5);
        findSecondLargest(arr5); // prints error message
    }

    /**
     * Utility method to print an array
     */
    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());

    }
}
