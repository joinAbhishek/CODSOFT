import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int minRange = 1;
            int maxRange = 100;
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            int maxAttempts = 7;
            int attempts = 0;
            int roundsWon = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts to guess it.");

            do {
                System.out.println("Attempts left: " + (maxAttempts - attempts));
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        roundsWon++;
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                }
            } while (attempts < maxAttempts);

            if (attempts >= maxAttempts) {
                System.out.println("Out of attempts. The correct number was: " + secretNumber);
            }

            System.out.println("You've won " + roundsWon + " round(s). Play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline character

            if (playAgain == 'n' || playAgain == 'N') {
                System.out.println("Thanks for playing. Your total score is: " + roundsWon + " round(s) won.");
            }
        } while (playAgain == 'y' || playAgain == 'Y');

        scanner.close();
    }
}
