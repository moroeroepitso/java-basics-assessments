package part2.arrayfundamentals;

/**
 *
 * @author botho
 */
public class CopyArrayUsingIteration {

    // Method to copy an int array by iterating over each element
    public static int[] copyArray(int[] source) {
        // Handle null input
        if (source == null) {
            return null;
        }

        // Create new array of same length
        int[] destination = new int[source.length];

        // Iterate and copy each element
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }

        return destination;
    }

    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int[] copied = copyArray(original);

        // Display both arrays to verify copy
        System.out.print("Original: ");
        for (int v : original) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Copied:   ");
        for (int v : copied) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
