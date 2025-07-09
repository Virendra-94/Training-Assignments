package Day2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        String operator = input.next();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        double result;

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                    input.close();
                    return;
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("Invalid operator. Use +, -, *, or /");
                input.close();
                return;
            }
        }

        System.out.println("Result: " + result);
        input.close();
    }
}
