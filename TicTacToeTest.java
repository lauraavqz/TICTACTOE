
public class TicTacToeTest {

    @Test
    public void testInitializeBoard() {
        TicTacToe.initializeBoard();
        char[][] board = TicTacToe.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }

    @Test
    public void testCheckWinner() {
        TicTacToe.initializeBoard();
        char[][] board = TicTacToe.getBoard();
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        assertTrue(TicTacToe.checkWinner());

        TicTacToe.initializeBoard();
        board[0][0] = 'O';
        board[1][0] = 'O';
        board[2][0] = 'O';
        assertTrue(TicTacToe.checkWinner());

        TicTacToe.initializeBoard();
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = 'X';
        assertTrue(TicTacToe.checkWinner());

        TicTacToe.initializeBoard();
        board[0][2] = 'O';
        board[1][1] = 'O';
        board[2][0] = 'O';
        assertTrue(TicTacToe.checkWinner());

        TicTacToe.initializeBoard();
        assertFalse(TicTacToe.checkWinner());
    }

    @Test
    public void testIsBoardFull() {
        TicTacToe.initializeBoard();
        assertFalse(TicTacToe.isBoardFull());

        char[][] board = TicTacToe.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 'X';
            }
        }
        assertTrue(TicTacToe.isBoardFull());
    }

    @Test
    public void testSwitchPlayer() {
        TicTacToe.switchPlayer();
        assertEquals('O', TicTacToe.getCurrentPlayer());
        TicTacToe.switchPlayer();
        assertEquals('X', TicTacToe.getCurrentPlayer());
    }
}
