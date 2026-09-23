package part2.arrayfundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Comprehensive guide to converting arrays to ArrayLists in Java. Demonstrates
 * 5 different methods with examples and best practices.
 *
 * @author botho
 */
public class ConvertAnArraytoanArrayList {

    public static void main(String[] args) {

        // Example 1: Converting a String array using Arrays.asList()
        System.out.println("=== Method 1: Using Arrays.asList() ===");
        method1_ArraysAsList();

        // Example 2: Converting using a traditional for loop
        System.out.println("\n=== Method 2: Using Traditional For Loop ===");
        method2_TraditionalLoop();

        // Example 3: Converting using an enhanced for loop
        System.out.println("\n=== Method 3: Using Enhanced For Loop ===");
        method3_EnhancedLoop();

        // Example 4: Converting using Java Streams (Java 8+)
        System.out.println("\n=== Method 4: Using Java Streams ===");
        method4_Streams();

        // Example 5: Converting using the ArrayList constructor
        System.out.println("\n=== Method 5: Using ArrayList Constructor ===");
        method5_Constructor();

        // Example 6: Demonstrating the immutability issue and its solution
        System.out.println("\n=== Immutability Issue and Solution ===");
        demonstrateImmutability();
    }

    /**
     * Method 1: Arrays.asList() - The simplest and most concise approach.
     *
     * Pros: One line of code, very readable, direct conversion. Cons: Returns a
     * FIXED-SIZE list backed by the original array. Adding or removing elements
     * throws UnsupportedOperationException. (Note: set() still works because it
     * doesn't change the size.) Best for: When you only need to READ from the
     * list.
     */
    public static void method1_ArraysAsList() {
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};

        // Convert array to a List view using Arrays.asList()
        List<String> fruitList = Arrays.asList(fruits);

        System.out.println("Original array: " + Arrays.toString(fruits));
        System.out.println("Converted List: " + fruitList);
        System.out.println("Size: " + fruitList.size());

        // Demonstrate that it is a fixed-size list
        try {
            fruitList.add("Elderberry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add to this list (fixed-size): " + e.getMessage());
        }

        // But set() is allowed because it does NOT change the size
        fruitList.set(0, "Apricot");
        System.out.println("After set(0, \"Apricot\"): " + fruitList);
    }

    /**
     * Method 2: Traditional For Loop - Explicit and familiar approach.
     *
     * Pros: Full control over the conversion process, easy to debug. Cons: More
     * verbose than other methods. Best for: When you need custom logic during
     * conversion.
     */
    public static void method2_TraditionalLoop() {
        Integer[] numbers = {10, 20, 30, 40, 50};

        // Create an empty ArrayList to hold the elements
        ArrayList<Integer> numberList = new ArrayList<>(numbers.length);

        // Iterate through the array and add each element to the ArrayList
        for (int i = 0; i < numbers.length; i++) {
            numberList.add(numbers[i]);
        }

        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Converted ArrayList: " + numberList);

        // Now we can modify the ArrayList freely
        numberList.add(60);
        System.out.println("After adding 60: " + numberList);

        numberList.remove(0);
        System.out.println("After removing first element: " + numberList);
    }

    /**
     * Method 3: Enhanced For Loop - Clean and modern approach.
     *
     * Pros: Cleaner syntax than traditional loop, easier to read. Cons: Still
     * more verbose than Arrays.asList(). Best for: When readability is a
     * priority.
     */
    public static void method3_EnhancedLoop() {
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};

        // Create an ArrayList and populate it using enhanced for loop
        ArrayList<String> colorList = new ArrayList<>(colors.length);

        // For each element in the array, add it to the ArrayList
        for (String color : colors) {
            colorList.add(color);
        }

        System.out.println("Original array: " + Arrays.toString(colors));
        System.out.println("Converted ArrayList: " + colorList);
        System.out.println("Size: " + colorList.size());
    }

    /**
     * Method 4: Java Streams (Java 8+) - Functional programming approach.
     *
     * Pros: Very concise, functional style, powerful for
     * filtering/transforming. Cons: Requires Java 8 or higher, slightly steeper
     * learning curve. Best for: When you need to filter, transform, or process
     * data during conversion.
     */
    public static void method4_Streams() {
        Double[] prices = {9.99, 19.99, 29.99, 39.99, 49.99};

        // Convert array to ArrayList using streams.
        // Collectors.toCollection(ArrayList::new) guarantees a mutable ArrayList.
        ArrayList<Double> priceList = Arrays.stream(prices)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Original array: " + Arrays.toString(prices));
        System.out.println("Converted ArrayList: " + priceList);

        // Demonstrate combining conversion with filtering
        ArrayList<Double> expensiveItems = Arrays.stream(prices)
                .filter(price -> price > 25.0)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Filtered items (price > 25): " + expensiveItems);
    }

    /**
     * Method 5: ArrayList Constructor with Arrays.asList().
     *
     * Pros: Creates a TRUE mutable ArrayList, concise, fixes immutability
     * issue. Cons: Slightly more code than Arrays.asList() alone. Best for:
     * When you need a mutable ArrayList and want conciseness.
     */
    public static void method5_Constructor() {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter"};

        // Create ArrayList by passing the result of Arrays.asList() to constructor.
        // This creates a NEW ArrayList containing the elements, not a fixed-size view.
        ArrayList<String> planetList = new ArrayList<>(Arrays.asList(planets));

        System.out.println("Original array: " + Arrays.toString(planets));
        System.out.println("Converted ArrayList: " + planetList);

        // Now we can modify it freely
        planetList.add("Saturn");
        System.out.println("After adding Saturn: " + planetList);

        planetList.remove("Mercury");
        System.out.println("After removing Mercury: " + planetList);
    }

    /**
     * Demonstrates the immutability issue with Arrays.asList() and shows how to
     * solve it.
     */
    public static void demonstrateImmutability() {
        String[] animals = {"Cat", "Dog", "Bird", "Fish"};

        // Problem: Arrays.asList() returns a fixed-size list
        List<String> fixedSizeList = Arrays.asList(animals);
        System.out.println("Using Arrays.asList(): " + fixedSizeList);
        System.out.println("Can we add/remove? " + testModification(fixedSizeList));

        // Solution: Wrap with ArrayList constructor to create a truly mutable copy
        ArrayList<String> mutableList = new ArrayList<>(Arrays.asList(animals));
        System.out.println("\nUsing new ArrayList<>(Arrays.asList()): " + mutableList);
        System.out.println("Can we add/remove? " + testModification(mutableList));
    }

    /**
     * Helper method to test if a list is truly mutable.
     *
     * @param list The list to test.
     * @return true if we can add and remove an element, false otherwise.
     */
    private static boolean testModification(List<String> list) {
        try {
            list.add("Test");
            list.remove("Test");
            return true;
        } catch (UnsupportedOperationException e) {
            return false;
        }
    }
}
