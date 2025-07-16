package tollboothassignment;

public interface Truck {
    /**
     * Returns the number of axles the truck has.
     * @return An integer representing the number of axles.
     */
    int getAxles();

    /**
     * Returns the total weight of the truck in kilograms.
     * @return An integer representing the truck's total weight.
     */
    int getWeight();
    
    /**
     * Returns the make or brand of the truck.
     * @return A string representing the truck's make.
     */
    String getMake();
}
