package oopspractice;

import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Method to show current balance
    public void showBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Method to display account info
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for account details
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

