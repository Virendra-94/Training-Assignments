package oopspractice;

import java.util.Scanner;

class StudentInfo {
    String name;
    int yearOfJoining;
    String address;

    // Method to take student data from user
    public void getData() {
        System.out.print("Enter name: ");
        Scanner scanner=new Scanner(System.in);
        name = scanner.nextLine();

        System.out.print("Enter year of joining: ");
        yearOfJoining = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter address: ");
        address = scanner.nextLine();
    }

    // Method to display student information
    public void displayData() {
        System.out.printf("%-10s %-15d %s\n", name, yearOfJoining, address);
    }
}
public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   

        StudentInfo[] students = new StudentInfo[3];

        System.out.println("Enter information for 3 students:");
        for (int i = 0; i < 3; i++) {
            students[i] = new StudentInfo();
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].getData();
        }

        // Display the output in formatted table
        System.out.println("\nName       Year of joining  Address");
        for (StudentInfo s : students) {
            s.displayData();
        }

        
	}

}
