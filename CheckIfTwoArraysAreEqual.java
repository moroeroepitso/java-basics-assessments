package part2.arrayfundamentals;

public class CheckIfTwoArraysAreEqual {

    // Method to check if two arrays are equal
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        // Check if both arrays are null, if yes, they are equal
        if (array1 == null && array2 == null) {
            return true;
        }

        // If one of the arrays is null, the other is not, they are not equal
        if (array1 == null || array2 == null) {
            return false;
        }

        // Check if the lengths of both arrays are equal
        if (array1.length != array2.length) {
            return false; // Different lengths means arrays are not equal
        }

        // Check each corresponding element in both arrays
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false; // Found elements that are not equal
            }
        }

        // If all checks passed, the arrays are equal
        return true;
    }

    // Main method to test the equality checker
    public static void main(String[] args) {
        // Example arrays to test
        int[] arrayA = {1, 2, 3, 4};
        int[] arrayB = {1, 2, 3, 4};
        int[] arrayC = {1, 2, 3, 5};
        int[] arrayD = null;
        int[] arrayE = null; // This should be an array, so it should be declared as int[]

        // Test cases to check array equality
        System.out.println("Array A and Array B are equal: " + areArraysEqual(arrayA, arrayB)); // Should print true
        System.out.println("Array A and Array C are equal: " + areArraysEqual(arrayA, arrayC)); // Should print false
        System.out.println("Array D and Array E are equal: " + areArraysEqual(arrayD, arrayE)); // Should print true
        System.out.println("Array A and Array D are equal: " + areArraysEqual(arrayA, arrayD)); // Should print false
    }
}
