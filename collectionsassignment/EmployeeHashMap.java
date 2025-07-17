package collectionsassignment;

import java.util.HashMap;
import java.util.Map;

public class EmployeeHashMap {

    public static void main(String[] args) {

        // Create a HashMap with Integer keys and Employee object values.
        Map<Integer, Employee> employeesMap = new HashMap<>();

        // 1. Add 5 employees to the HashMap.
        employeesMap.put(101, new Employee(101, "Alice", "New York"));
        employeesMap.put(102, new Employee(102, "Bob", "London"));
        employeesMap.put(103, new Employee(103, "Charlie", "Tokyo"));
        employeesMap.put(104, new Employee(104, "David", "Sydney"));
        employeesMap.put(105, new Employee(105, "Eve", "Paris"));

        // Display all employees in the map.
        // We iterate over the entrySet to get both key and value.
        System.out.println("All Employee Details:");
        for (Map.Entry<Integer, Employee> entry : employeesMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("----------------------------------------");


        // 2. Display Employee details based on Employee ID (key).
        int employeeIdToFind = 103;
        System.out.println("Searching for Employee with ID: " + employeeIdToFind);

        // Check if the map contains the key before trying to get it.
        if (employeesMap.containsKey(employeeIdToFind)) {
            Employee foundEmployee = employeesMap.get(employeeIdToFind);
            System.out.println("Employee Found: " + foundEmployee);
        } else {
            System.out.println("Employee with ID " + employeeIdToFind + " not found.");
        }
        
        System.out.println("----------------------------------------");
        
        // Example for a non-existent employee
        int employeeIdToFail = 999;
         System.out.println("Searching for Employee with ID: " + employeeIdToFail);
         if (employeesMap.containsKey(employeeIdToFail)) {
            Employee foundEmployee = employeesMap.get(employeeIdToFail);
            System.out.println("Employee Found: " + foundEmployee);
        } else {
            System.out.println("Employee with ID " + employeeIdToFail + " not found.");
        }
    }
}