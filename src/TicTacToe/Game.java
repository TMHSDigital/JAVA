package TicTacToe;

public class Game {
    public static final int BOARD_SIZE = 3;
    public char[][] board;
    public Player currentPlayer;

    public Game() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = Player.X;
        initializeBoard();
    }

    // Initializes the board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Prints the current state of the board
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < BOARD_SIZE - 1) System.out.print("|");
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) System.out.println("  -----");
        }
    }

    // Handles a player's move
    public boolean playerMove(int row, int col) {
        if (row < 0 || col < 0 || row >= BOARD_SIZE || col >= BOARD_SIZE) {
            System.out.println("This move is out of bounds");
            return false;
        } else if (board[row][col] != ' ') {
            System.out.println("This cell is already occupied");
            return false;
        } else {
            board[row][col] = currentPlayer.getSymbol();
            return true;
        }
    }

    // Checks if the current player has won
    public boolean checkWinner() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == currentPlayer.getSymbol() && board[i][1] == currentPlayer.getSymbol() && board[i][2] == currentPlayer.getSymbol()) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[0][j] == currentPlayer.getSymbol() && board[1
