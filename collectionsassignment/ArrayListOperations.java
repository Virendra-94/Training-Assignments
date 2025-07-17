package collectionsassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListOperations {

    public static void main(String[] args) {

        // 1. Create a new ArrayList of strings and add some colors.
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        System.out.println("Original ArrayList: " + colors);
        System.out.println("--------------------");

        // 2. Iterate through all elements in the ArrayList.
        System.out.println("Iterating through the list:");
        for (String color : colors) {
            System.out.println(color);
        }
        System.out.println("--------------------");

        // 3. Insert an element into the ArrayList at the first position.
        colors.add(0, "Orange"); // Adds "Orange" at index 0
        System.out.println("After inserting 'Orange' at the first position: " + colors);
        System.out.println("--------------------");

        // 4. Retrieve an element at a specified index.
        String firstColor = colors.get(0); // Retrieves the element at index 0
        System.out.println("Element at index 0: " + firstColor);
        System.out.println("--------------------");

        // 5. Update a specific array element by a given element.
        colors.set(1, "Purple"); // Replaces the element at index 1 with "Purple"
        System.out.println("After updating the element at index 1 to 'Purple': " + colors);
        System.out.println("--------------------");

        // 6. Remove the third element from the ArrayList.
        colors.remove(2); // Removes the element at index 2
        System.out.println("After removing the third element (at index 2): " + colors);
        System.out.println("--------------------");

        // 7. Search for an element in the ArrayList.
        boolean hasBlue = colors.contains("Blue");
        System.out.println("Does the list contain 'Blue'? " + hasBlue);
        int indexOfYellow = colors.indexOf("Yellow");
        System.out.println("Index of 'Yellow': " + indexOfYellow);
        System.out.println("--------------------");

        // 8. Sort the given ArrayList.
        Collections.sort(colors);
        System.out.println("Sorted ArrayList: " + colors);
        System.out.println("--------------------");

        // 9. Copy one ArrayList into another.
        ArrayList<String> copiedColors = new ArrayList<>();
        copiedColors.addAll(colors);
        System.out.println("Copied ArrayList: " + copiedColors);
        System.out.println("--------------------");

        // 10. Shuffle elements in an ArrayList.
        Collections.shuffle(colors);
        System.out.println("Shuffled ArrayList: " + colors);
        System.out.println("--------------------");

        // 11. Reverse elements in an ArrayList.
        Collections.reverse(colors);
        System.out.println("Reversed ArrayList: " + colors);
        System.out.println("--------------------");

        // 12. Extract a portion of an ArrayList.
        // Note: The 'toIndex' in subList is exclusive.
        List<String> subList = colors.subList(1, 3);
        System.out.println("Portion of the list (from index 1 to 2): " + subList);
        System.out.println("--------------------");
        
        // 13. Replace the second element of an ArrayList with a specified element.
        if (colors.size() >= 2) {
            colors.set(1, "Cyan"); // Replaces element at index 1
            System.out.println("After replacing the second element with 'Cyan': " + colors);
        } else {
            System.out.println("ArrayList does not have a second element to replace.");
        }
        System.out.println("--------------------");
    }
}