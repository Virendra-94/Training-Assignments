package tollboothassignment;

/**
 * TollBooth.java
 * This interface defines the standard operations for a tollbooth.
 * It includes calculating tolls, displaying data, and managing receipts.
 */
public interface TollBooth {
    /**
     * Calculates the toll for a given truck and updates the totals.
     * This method also prints the details of the arriving truck and the toll due.
     * @param truck The truck arriving at the tollbooth.
     */
    void calculateToll(Truck truck);

    /**
     * Displays the current totals for receipts and the number of trucks
     * since the last collection.
     */
    void displayData();

    /**
     * Simulates the collection of receipts. It displays the final totals
     * and then resets the receipt and truck counts to zero.
     */
    void collectReceipts();
}
