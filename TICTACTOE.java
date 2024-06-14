import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            playerMove();
            printBoard();
            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("The game is a draw!");
                break;
            }
            switchPlayer();
        }
    }

    /**
     * Initializes the game board with empty cells represented by '-'.
     */
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    /**
     * Prints the current state of the game board.
     */
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prompts the current player to make a move.
     * The move is validated to ensure it's within the board and the cell is empty.
     */
    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    /**
     * Checks if the current player has won the game.
     * @return true if the current player has a winning combination, false otherwise.
     */
    public static boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the game board is full, meaning no more moves can be made.
     * @return true if the board is full, false otherwise.
     */
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Switches the current player from 'X' to 'O' or from 'O' to 'X'.
     */
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    /**
     * Returns the current state of the game board.
     * @return the game board
     */
    public static char[][] getBoard() {
        return board;
    }

    /**
     * Returns the current player.
     * @return the current player
     */
    public static char getCurrentPlayer() {
        return currentPlayer;
    }
}
