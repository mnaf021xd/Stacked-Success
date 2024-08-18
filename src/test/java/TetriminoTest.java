import com.stackedsuccess.Action;
import com.stackedsuccess.GameBoard;
import com.stackedsuccess.controllers.GameBoardController;
import com.stackedsuccess.tetriminos.Tetrimino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TetriminoTest {

    private GameBoard gameBoard;
    private GameBoardController mockController;

    @BeforeEach
    public void setUp() {
        mockController = Mockito.mock(GameBoardController.class);
        gameBoard = new GameBoard();
        gameBoard.setController(mockController);
    }

    @Test
    public void testTetriminoLeft() {
        Tetrimino t = gameBoard.getCurrentTetrimino();
        int before = t.getXPos();
        t.updateTetrimino(gameBoard, Action.MOVE_LEFT);
        int after = t.getXPos();
        assertEquals(before - 1, after);
    }

    @Test
    public void testTetriminoRight() {
        Tetrimino t = gameBoard.getCurrentTetrimino();
        int before = t.getXPos();
        t.updateTetrimino(gameBoard, Action.MOVE_RIGHT);
        int after = t.getXPos();
        assertEquals(before + 1, after);
    }

    @Test
    public void testTetriminoDown() {
        Tetrimino t = gameBoard.getCurrentTetrimino();
        int before = t.getYPos();
        t.updateTetrimino(gameBoard, Action.MOVE_DOWN);
        int after = t.getYPos();
        assertEquals(before + 1, after);
    }

    @Test
    public void testTetriminoPause() {
        Tetrimino t = gameBoard.getCurrentTetrimino();
        int before = t.getYPos();
        t.updateTetrimino(gameBoard, Action.PAUSE);
        int after = t.getYPos();
        assertEquals(before, after);
    }
    
}
