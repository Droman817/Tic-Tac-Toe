import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testValidMove() {
        Board board = new Board();
        assertTrue(board.makeMove(1, 'X'));
    }

    @Test
    void testInvalidMoveTakenCell() {
        Board board = new Board();
        board.makeMove(1, 'X');
        assertFalse(board.makeMove(1, 'O'));
    }

    @Test
    void testWinCondition() {
        Board board = new Board();
        board.makeMove(1, 'X');
        board.makeMove(2, 'X');
        board.makeMove(3, 'X');
        assertTrue(board.checkWin());
    }

    @Test
    void testDrawCondition() {
        Board board = new Board();

        board.makeMove(1,'X');
        board.makeMove(2,'O');
        board.makeMove(3,'X');
        board.makeMove(4,'X');
        board.makeMove(5,'O');
        board.makeMove(6,'O');
        board.makeMove(7,'O');
        board.makeMove(8,'X');
        board.makeMove(9,'X');

        assertTrue(board.isDraw());
    }
}