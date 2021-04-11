import java.util.ArrayList;


public class Sudoku {

    public static void main(String[] args) {

        Board board = new Board();
        Solve solver = new Solve();

        ArrayList<Position> positions = solver.recordPositions(board.getBoard());

        solver.solveSudoku(positions, 0, board.getBoard());

        board.display();

        board.addZeros(100);

        board.display();

        positions.clear();

        positions = solver.recordPositions(board.getBoard());

        solver.solveSudoku(positions, 0, board.getBoard());

        board.display();

    }
}

