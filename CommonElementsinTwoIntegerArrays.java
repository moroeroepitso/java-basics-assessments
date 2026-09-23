package part2.arrayfundamentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the common elements (intersection) between two integer arrays.
 *
 * Approach: Use a HashSet to store elements of the first array, then iterate
 * through the second array and collect those that appear in the set. This gives
 * distinct common elements in O(n + m) time and O(min(n,m)) space.
 *
 * If you need all occurrences (including duplicates), an alternative using
 * HashMap/ArrayList is provided (see findCommonElementsWithDuplicates).
 *
 * @author botho
 */
public class CommonElementsinTwoIntegerArrays {

    /**
     * Returns an array containing the distinct elements that appear in both
     * input arrays.
     *
     * @param arr1 First integer array (can be null or empty)
     * @param arr2 Second integer array (can be null or empty)
     * @return An int[] of distinct common elements, or an empty array if none.
     */
    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        // Edge case: if either array is null, return an empty array
        if (arr1 == null || arr2 == null) {
            return new int[0];
        }

        // Step 1: Build a set from the first array.
        // Using HashSet gives O(1) average lookup time.
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        // Step 2: Use another set to store the common elements
        // (automatically avoids duplicates).
        Set<Integer> common = new HashSet<>();
        for (int num : arr2) {
            if (set.contains(num)) {
                common.add(num);
            }
        }

        // Step 3: Convert the result set to an int array.
        int[] result = new int[common.size()];
        int index = 0;                         // FIXED: 'index' was never declared
        for (int num : common) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Alternative method that preserves duplicates. Returns all occurrences of
     * common elements (bag intersection). E.g., arr1=[1,2,2,3,2,4],
     * arr2=[2,2,2] → result=[2,2,2]
     *
     * @param arr1 First array
     * @param arr2 Second array
     * @return array containing all matching occurrences (duplicates preserved)
     */
    // FIXED: method signature was truncated and corrupted ("findCommonElementsWithDu1, int[] arr2)")
    public static int[] findCommonElementsWithDuplicates(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return new int[0];
        }

        // Build a frequency map of the first array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            // FIXED: line was broken — "map.put(num, map.getOrDefault(num, 0) + 1);"
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect common elements considering frequency
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr2) {
            // FIXED: line was corrupted — ".add(num);"
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1); // decrease count
            }
        }

        // Convert ArrayList to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // FIXED: was truncated — "result[i        }"
            result[i] = list.get(i);
        }
        return result;
    }

    // --- Demonstration in main ---
    public static void main(String[] args) {
        // Test case 1: Normal case with no duplicates
        int[] arr1 = {1, 2, 3, 4, 5};
        // FIXED: array initializer was corrupted — "{4, 5, 6, 7};"
        int[] arr2 = {3, 4, 5, 6, 7};
        System.out.println("Array1: [1, 2, 3, 4, 5]");
        System.out.println("Array2: [3, 4, 5, 6, 7]");
        // FIXED: call was truncated — "findCommonElements2);"
        int[] common = findCommonElements(arr1, arr2);
        System.out.print("Distinct common elements: ");
        printArray(common);
        System.out.println();

        // Test case 2: Duplicates in both arrays
        int[] arr3 = {2, 2, 3, 5, 5};
        int[] arr4 = {2, 2, 5, 5, 7};
        System.out.println("Array3: [2, 2, 3, 5, 5]");
        System.out.println("Array4: [2, 2, 5, 5, 7]");
        int[] distinct = findCommonElements(arr3, arr4);
        System.out.print("Distinct common: ");
        printArray(distinct);
        // With duplicates preserved:
        int[] withDups = findCommonElementsWithDuplicates(arr3, arr4);
        System.out.print("With duplicates preserved: ");
        printArray(withDups);
        System.out.println();

        // Test case 3: No common elements
        int[] arr5 = {10, 20, 30};
        int[] arr6 = {40, 50};
        System.out.println("Array5: [10, 20, 30]");
        System.out.println("Array6: [40, 50]");
        int[] none = findCommonElements(arr5, arr6);
        System.out.print("Common (none): ");
        printArray(none);
        System.out.println();

        // Test case 4: One array is empty
        int[] arr7 = {};
        int[] arr8 = {1, 2, 3};
        System.out.println("Array7: []");
        System.out.println("Array8: [1, 2, 3]");
        int[] emptyResult = findCommonElements(arr7, arr8);
        System.out.print("Common: ");
        printArray(emptyResult);
        System.out.println();

        // Test case 5: Null arrays
        int[] nullResult = findCommonElements(null, arr8);
        System.out.println("Null result length: " + nullResult.length); // should be 0
    }

    /**
     * Utility method to print an integer array
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
