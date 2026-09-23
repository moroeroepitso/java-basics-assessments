package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class CountEvenandOddNumbersinanArray {

    public static void countEvenOdd(int[] arr) {
        // Handle empty array
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int evenCount = 0;
        int oddCount = 0;

        // Iterate through each element
        for (int num : arr) {
            // If divisible by 2, it's even; otherwise odd
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        countEvenOdd(numbers);

    }
}
