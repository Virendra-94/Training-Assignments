package tollboothassignment;

/**
 * FordTruck.java
 * An implementation of the Truck interface, representing a Ford truck.
 */
class FordTruck implements Truck {
    private final int axles;
    private final int weight;
    private final String make = "Ford";

    /**
     * Constructor for the FordTruck class.
     * @param axles The number of axles for the truck.
     * @param weight The total weight of the truck in kilograms.
     */
    public FordTruck(int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
    }

    @Override
    public int getAxles() {
        return axles;
    }

    @Override
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String getMake() {
        return make;
    }
}

/**
 * NissanTruck.java
 * An implementation of the Truck interface, representing a Nissan truck.
 */
class NissanTruck implements Truck {
    private final int axles;
    private final int weight;
    private final String make = "Nissan";

    /**
     * Constructor for the NissanTruck class.
     * @param axles The number of axles for the truck.
     * @param weight The total weight of the truck in kilograms.
     */
    public NissanTruck(int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
    }

    @Override
    public int getAxles() {
        return axles;
    }

    @Override
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String getMake() {
        return make;
    }
}

/**
 * DaewooTruck.java
 * An implementation of the Truck interface, representing a Daewoo truck.
 */
class DaewooTruck implements Truck {
    private final int axles;
    private final int weight;
    private final String make = "Daewoo";

    /**
     * Constructor for the DaewooTruck class.
     * @param axles The number of axles for the truck.
     * @param weight The total weight of the truck in kilograms.
     */
    public DaewooTruck(int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
    }

    @Override
    public int getAxles() {
        return axles;
    }

    @Override
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String getMake() {
        return make;
    }
}

