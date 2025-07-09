package Day3;

//GradeEvaluator.java
import java.util.Scanner;

public class GradeEvaluator {
 public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.print("Enter your score (0-100): ");
     int score = input.nextInt();

     if (score >= 90 && score <= 100)
         System.out.println("Your grade is A.");
     else if (score >= 80)
         System.out.println("Your grade is B.");
     else if (score >= 70)
         System.out.println("Your grade is C.");
     else if (score >= 60)
         System.out.println("Your grade is D.");
     else if (score >= 0)
         System.out.println("Your grade is F.");
     else
         System.out.println("Invalid score.");

     input.close();
 }
}
