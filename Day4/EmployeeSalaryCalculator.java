package oopspractice;
//Assignments Day4:
//1) Write a program by creating an Employee class having the following methods and print
//the final salary.
//1 - getInfo(); which takes the salary, number of hours of work per day of employee as
//parameter
//2 - addSal(); which adds $10 to salary of the employee if it is less than $500.
//3 - addWork(); which adds $5 to salary of employee if the number of hours of work per
//day is more than 6 hours.
import java.util.Scanner;

class Employee {
     int salary;
     int hoursPerDay,ans=0;

    // Method 1: Get employee info
    public void getInfo() {
      Scanner sc =new Scanner(System.in);
      System.out.println("Enter salary of per day and working hours of per day: ");
      salary=sc.nextInt();
      hoursPerDay=sc.nextInt();
      sc.close();
    }

    
    // Method 2 and 3
    public void addWork() {
        if (hoursPerDay > 6 && salary<500) {
        	
        	ans+=15+(salary*hoursPerDay);
        }
        else if(hoursPerDay > 6 && salary>500)
        {
        	ans+=5+(salary*hoursPerDay);
        }
        else if(hoursPerDay < 6 && salary<500)
        {
        	ans+=10+(salary*hoursPerDay);
        }
        else
        {
        	ans+=salary*hoursPerDay;
        }
    }

    // Method to get final salary
    public int getFinalSalary() {
        return ans;
    }
}

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        

        // Create employee object
        Employee emp = new Employee();

        // Get user input
   
        // Process salary
        emp.getInfo();
        
        emp.addWork();

        // Print final salary
        System.out.println("Final salary of the employee is: $" + emp.getFinalSalary());

    }
}
