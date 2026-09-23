package part2.arrayfundamentals;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author botho
 */
public class FindDuplicatesInanIntegerArray {

    public static void main(String[] args) {
        // Sample integer array with duplicates
        int[] numbers = {1, 2, 3, 4, 5, 2, 6, 3, 7, 8};

        // Find and print duplicate values
        Set<Integer> duplicates = findDuplicates(numbers);
        System.out.println("Duplicate values: " + duplicates);
    }

    /**
     * This method finds duplicate values in an integer array.
     *
     * @param array The array of integers to be checked for duplicates.
     * @return A set of duplicate values found in the array.
     */
    public static Set<Integer> findDuplicates(int[] array) {
        // A set to store unique values seen so far
        Set<Integer> seen = new HashSet<>();
        // A set to store duplicates
        Set<Integer> duplicates = new HashSet<>();

        // Iterate through each number in the array
        for (int number : array) {
            // If the number is already in the 'seen' set, it's a duplicate
            if (!seen.add(number)) {
                // Add to duplicates set if not already present
                duplicates.add(number);
            }
        }

        return duplicates; // Return the set of duplicates

    }
}
