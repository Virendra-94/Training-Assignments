package Day3;

//NumberReverser.java
import java.util.Scanner;

public class NumberReverser {
 public static void main(String[] args) {
     Scanner reader = new Scanner(System.in);
     System.out.print("Enter a number: ");
     int num = reader.nextInt();
     int reversed = 0;

     while (num != 0) {
         int digit = num % 10;
         reversed = reversed * 10 + digit;
         num /= 10;
     }

     System.out.println("The reversed number is " + reversed + ".");
     reader.close();
 }
}
