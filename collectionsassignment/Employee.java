package collectionsassignment;

public class Employee {
    // Fields for the Employee object
    private int id;
    private String name;
    private String city;

    // Constructor to initialize an Employee object
    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getter methods to access the private fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Override the toString() method for a user-friendly display of the object
    @Override
    public String toString() {
        return "Employee[ID=" + id + ", Name='" + name + "', City='" + city + "']";
    }
}