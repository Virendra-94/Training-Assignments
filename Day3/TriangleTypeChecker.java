package Day3;

//TriangleTypeChecker.java
import java.util.Scanner;

public class TriangleTypeChecker {
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     System.out.print("Enter side 1: ");
     int a = in.nextInt();
     System.out.print("Enter side 2: ");
     int b = in.nextInt();
     System.out.print("Enter side 3: ");
     int c = in.nextInt();

     if (a == b && b == c)
         System.out.println("The triangle is equilateral.");
     else if (a == b || b == c || a == c)
         System.out.println("The triangle is isosceles.");
     else
         System.out.println("The triangle is scalene.");

     in.close();
 }
}
