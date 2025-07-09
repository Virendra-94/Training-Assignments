package Day3;

//StarPatternPrinter.java
public class StarPatternPrinter {
 public static void main(String[] args) {
     int rows = 5;

     // Top Half
     for (int i = 1; i <= rows; i++) {
         for (int j = 1; j <= 2 * i - 1; j++) {
             System.out.print("* ");
         }
         System.out.println();
     }

     // Bottom Half
     for (int i = rows - 1; i >= 1; i--) {
         for (int j = 1; j <= 2 * i - 1; j++) {
             System.out.print("* ");
         }
         System.out.println();
     }
 }
}

