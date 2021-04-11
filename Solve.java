import java.util.ArrayList;
import java.util.Collections;

public class Solve {



    private boolean rowConstraint(int row, int num, int[][] board) {
        //check row
        for (int c = 0; c < 9; c++) {
            if (board[c][row] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean colConstraint(int col, int num, int[][] board) {
        //check column
        for (int r = 0; r < 9; r++) {
            if (board[col][r] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean subsectionConstraint(int row, int col, int num, int [][] board) {

        //check subsection
        int subsectionRowSize = 3;
        int subsectionColSize = 3;
        int subsectionRowStart = row - (row % subsectionRowSize);
        int subsectionColStart = col - (col % subsectionColSize);

        for (int i = subsectionRowStart; i < subsectionRowStart + subsectionRowSize; i++) {
            for (int j = subsectionColStart; j < subsectionColStart + subsectionColSize; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private boolean checkConstraints(int row, int col, int num, int[][] board) {
        return rowConstraint(col, num, board) && colConstraint(row, num, board) &&
                subsectionConstraint(row, col, num, board);
    }

    public ArrayList<Position> recordPositions(int[][] board) {
        ArrayList<Position> emptyPosition = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    emptyPosition.add(new Position(i, j));
                }
            }
        }
        return emptyPosition;
    }


    public boolean solveSudoku(ArrayList<Position> position, int index, int[][] board) {

        if(index == position.size()){
            return true;
        }

        int row;
        int col;

        ArrayList<Integer> numbers = new ArrayList<>(10);
        for(int n = 1; n < 10; n++){
            numbers.add(n);
        }
        Collections.shuffle(numbers);

        for (Integer number : numbers) {
            row = position.get(index).getRow();
            col = position.get(index).getCol();
            if (checkConstraints(row, col, number, board)) {
                board[row][col] = number;
                if (solveSudoku(position, index + 1, board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

}

