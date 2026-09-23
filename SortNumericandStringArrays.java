package part2.arrayfundamentals;

import java.util.Arrays;

/**
 *
 * @author botho
 */
public class SortNumericandStringArrays {

    /**
     * This class demonstrates sorting of numeric and string arrays using Java's
     * built-in Arrays.sort() method.
     *
     * For primitive numeric arrays (e.g., int[]), Arrays.sort() uses a
     * Dual-Pivot Quicksort algorithm (O(n log n) average time). For object
     * arrays (e.g., String[]), it uses TimSort – a stable, adaptive merge sort
     * (also O(n log n) in the worst case).
     *
     */
    public static void main(String[] args) {

        // ============================================================
        // 1. SORTING A NUMERIC ARRAY (int[])
        // ============================================================
        // Define and initialize an unsorted integer array
        int[] numericArray = {42, 7, 19, 3, 88, 1, 56, 34};

        // Print the original array
        System.out.println("Original Numeric Array: " + Arrays.toString(numericArray));

        // Sort the numeric array in ascending natural order
        // Arrays.sort(int[] a) modifies the array in-place (no return value)
        Arrays.sort(numericArray);

        // Print the sorted array
        System.out.println("Sorted Numeric Array (ascending): " + Arrays.toString(numericArray));

        // ============================================================
        // 2. SORTING A STRING ARRAY (String[])
        // ============================================================
        // Define and initialize an unsorted string array
        String[] stringArray = {
            "banana", "Apple", "cherry", "apple", "Banana", "date"
        };

        // Print the original array
        System.out.println("\nOriginal String Array: " + Arrays.toString(stringArray));

        // Sort the string array in natural (lexicographic) order.
        // Note: Sorting is case‑sensitive because String implements
        // Comparable<String> using Unicode/ASCII order.
        // Upper‑case letters (A‑Z) come before lower‑case (a‑z).
        Arrays.sort(stringArray);

        // Print the sorted array
        System.out.println("Sorted String Array (natural order): " + Arrays.toString(stringArray));

        // ------------------------------------------------------------
        // Optional: Sort ignoring case (case‑insensitive order)
        // ------------------------------------------------------------
        String[] stringArray2 = {"banana", "Apple", "cherry", "apple", "Banana", "date"};
        System.out.println("\nOriginal String Array: " + Arrays.toString(stringArray2));

        // Use the overloaded Arrays.sort(T[], Comparator) with
        // String.CASE_INSENSITIVE_ORDER to get case‑insensitive sorting
        Arrays.sort(stringArray2, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Sorted String Array (case‑insensitive): " + Arrays.toString(stringArray2));

    }
}
