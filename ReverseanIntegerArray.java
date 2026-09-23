package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class ReverseanIntegerArray {

    // Method to reverse an integer array in place
    public static void reverse(int[] arr) {
        int left = 0;          // Start index
        int right = arr.length - 1; // End index

        // Swap elements from both ends moving inward
        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;  // Move left pointer right
            right--; // Move right pointer left
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.print("Original array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        reverse(numbers);

        System.out.print("Reversed array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
