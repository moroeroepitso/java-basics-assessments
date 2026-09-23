package part2.arrayfundamentals;

/**
 * Removes a specific element (by value) from an integer array. Since arrays
 * have fixed size, a new array is created containing all elements except the
 * ones matching the target value. The order of the remaining elements is
 * preserved.
 *
 * @author botho
 */
public class RemoveaSpecificElementfromAnArray {

    /**
     * Removes ALL occurrences of the given key from the input array.
     *
     * @param arr the original array (not modified)
     * @param key the value to be removed
     * @return a new array with all occurrences of key removed. If the key is
     * not present, a copy of the original array is returned.
     */
    public static int[] removeElement(int[] arr, int key) {
        // Step 1: Count how many times the key appears in the array.
        int count = 0;
        for (int num : arr) {
            if (num == key) {
                count++;
            }
        }

        // Step 2: If the key was not found, return a copy of the original array.
        if (count == 0) {
            return arr.clone(); // defensive copy
        }

        // Step 3: Create a new array with size = original length - count.
        int[] result = new int[arr.length - count];

        // Step 4: Copy all elements that are NOT equal to the key into the new array.
        int index = 0;
        for (int num : arr) {
            if (num != key) {
                result[index++] = num;
            }
        }

        // Step 5: Return the new array.
        return result;
    }

    /**
     * (Optional) Removes the element at a specific index. This demonstrates an
     * alternative operation – removing by index.
     *
     * @param arr original array
     * @param idx index of element to remove (0-based)
     * @return a new array with the element at idx removed, or the original
     * array if idx is invalid.
     */
    public static int[] removeByIndex(int[] arr, int idx) {
        // Check if index is valid
        if (arr == null || idx < 0 || idx >= arr.length) {
            return arr; // invalid index, return as is
        }

        // Create new array of size one less
        int[] result = new int[arr.length - 1];

        // Copy elements, skipping the one at idx
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) {
                continue; // skip the element to be removed
            }
            result[j++] = arr[i];
        }
        return result;
    }

    // --- Demonstration in main ---
    public static void main(String[] args) {
        // Example array (corrected initialization)
        int[] numbers = {9, 1, 5, 6, 5};

        System.out.println("Original array:");
        printArray(numbers);

        // Remove all occurrences of value 5
        int[] removed = removeElement(numbers, 5);
        System.out.println("\nAfter removing all 5s:");
        printArray(removed);

        // Preserve the original array (it remains unchanged)
        System.out.println("\nOriginal array still intact:");
        printArray(numbers);

        // Demonstrate removing by index (optional)
        int[] removedIndex = removeByIndex(numbers, 2);
        System.out.println("\nAfter removing element at index 2 (value 9):");
        printArray(removedIndex); // FIXED: was incorrectly calling a non-existent method
    }

    /**
     * Utility method to print an array in a readable format.
     */
    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
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
