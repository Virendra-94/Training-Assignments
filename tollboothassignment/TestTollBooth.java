package tollboothassignment;

/**
 * TestTollBooth.java
 * This class contains the main method to test the TollBooth simulation.
 * It creates a tollbooth and several trucks, then simulates their interaction.
 */
public class TestTollBooth {

    public static void main(String[] args) {
        // Create an instance of the tollbooth
        TollBooth booth = new AlleghenyTollBooth();

        // Create instances of different trucks
        Truck ford = new FordTruck(5, 12500);
        Truck nissan = new NissanTruck(2, 5000);
        Truck daewoo = new DaewooTruck(6, 17000);

        // Simulate truck arrivals and toll calculation
        booth.calculateToll(ford);
        booth.calculateToll(nissan);
        booth.calculateToll(daewoo);

        // Simulate collecting the receipts and resetting the booth
        booth.collectReceipts();
    }
}

