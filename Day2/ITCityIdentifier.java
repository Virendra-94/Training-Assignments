package Day2;

//ITCityIdentifier.java
import java.util.Scanner;

public class ITCityIdentifier {
 public static void main(String[] args) {
     Scanner cityInput = new Scanner(System.in);
     System.out.print("Enter a city name: ");
     String enteredCity = cityInput.nextLine().toLowerCase();

     if (enteredCity.equals("delhi") ||
         enteredCity.equals("mumbai") ||
         enteredCity.equals("kolkata") ||
         enteredCity.equals("bangalore") ||
         enteredCity.equals("chennai") ||
         enteredCity.equals("hyderabad")) {
         System.out.println("Yes, " + enteredCity + " is considered an IT City.");
     } else {
         System.out.println("No, " + enteredCity + " is not an IT City.");
     }

     cityInput.close();
 }
}
