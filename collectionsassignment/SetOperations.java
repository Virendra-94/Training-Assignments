package collectionsassignment;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {

        // Create the first HashSet
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(8);
        set1.add(9);
        System.out.println("Set 1: " + set1);

        // Create the second HashSet
        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(7);
        System.out.println("Set 2: " + set2);
        System.out.println("--------------------");

        // --- Union Operation ---
        // Create a new set for the union to keep the original sets unchanged.
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); // Add all elements from set2 to the unionSet.
                               // Duplicates are automatically ignored.
        System.out.println("Union : " + unionSet);
        System.out.println("--------------------");


        // --- Intersection Operation ---
        // Create a new set for the intersection.
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // Keep only the elements that are also in set2.
        System.out.println("Intersection : " + intersectionSet);
        System.out.println("--------------------");


        // --- Difference Operation (set1 - set2) ---
        // Create a new set for the difference.
        Set<Integer> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2); // Remove all elements from differenceSet that are present in set2.
        System.out.println("Difference (Set 1 - Set 2) : " + differenceSet);
        System.out.println("--------------------");
    }
}