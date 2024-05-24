import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + rounds + " rounds to play.");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess a number between 1 and 100:");

            while (!hasGuessedCorrectly && numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int points = maxAttempts - numberOfAttempts + 1;
                    totalScore += points;
                    System.out.println("Congratulations! You've guessed the correct number in " + numberOfAttempts + " attempts. You earned " + points + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Higher! Try again.");
                } else {
                    System.out.println("Lower! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame over! Your total score is: " + totalScore);

        scanner.close();
    }
}