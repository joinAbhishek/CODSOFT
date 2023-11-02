import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class AtmInterface {
    private double balance;

    public AtmInterface(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private AtmInterface account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a PIN and account for the user
        String userPIN = "1234"; // Change to your desired PIN
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance $1000
        Map<String, BankAccount> userAccounts = new HashMap<>();
        userAccounts.put(userPIN, userAccount);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.next();

        if (userAccounts.containsKey(enteredPIN)) {
            BankAccount account = userAccounts.get(enteredPIN);
            ATM atm = new ATM(account);
            atm.start();
        } else {
            System.out.println("Invalid PIN. Exiting.");
        }
    }
}
