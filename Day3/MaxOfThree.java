package Day3;

//MaxOfThree.java
import java.util.Scanner;

public class MaxOfThree {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter first number: ");
     int num1 = scanner.nextInt();

     System.out.print("Enter second number: ");
     int num2 = scanner.nextInt();

     System.out.print("Enter third number: ");
     int num3 = scanner.nextInt();

     int largest = num1;

     if (num2 > largest)
         largest = num2;
     if (num3 > largest)
         largest = num3;

     System.out.println("The largest number is " + largest + ".");
     scanner.close();
 }
}
