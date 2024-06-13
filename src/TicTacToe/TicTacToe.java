package TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            game.printBoard();
            int row = -1, col = -1;
            boolean validMove = false;

            while (!validMove) {
                try {
                    System.out.println("Player " + game.currentPlayer.getSymbol() + ", enter your move (row and column, separated by a space): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    validMove = game.playerMove(row, col);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter two integers separated by a space.");
                    scanner.next(); // clear the invalid input
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }

            gameEnded = game.checkWinner();
            if (gameEnded) {
                game.printBoard();
                System.out.println("Player " + game.currentPlayer.getSymbol() + " wins!");
            } else {
                if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a tie!");
                    gameEnded = true;
                } else {
                    game.switchPlayer();
                }
            }
        }

        scanner.close();
    }
}
