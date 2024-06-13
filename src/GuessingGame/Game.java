package GuessingGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberToGuess;
    private int numberOfTries;
    private Random random;

    public Game() {
        random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;
    }

    public boolean play(int guess) {
        numberOfTries++;
        if (guess < numberToGuess) {
            System.out.println("Too low! Try again.");
            return false;
        } else if (guess > numberToGuess) {
            System.out.println("Too high! Try again.");
            return false;
        } else {
            System.out.println("Correct! You win! Number of tries: " + numberOfTries);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean hasWon = false;

        System.out.println("Welcome to the Guessing Game! Guess a number between 1 and 100:");

        while (!hasWon) {
            try {
                int guess = scanner.nextInt();
                hasWon = game.play(guess);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear the invalid input
            }
        }

        scanner.close();
    }
}
