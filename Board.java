import java.util.Random;
public class Board {

    int board[][] = new int[9][9];

    public void addZeros(int num){
        Random rand = new Random();
        for(int i = 0; i <= num; i++) {
            int rnd1 = rand.nextInt(board.length);
            int rnd2 = rand.nextInt(board[rnd1].length);
            board[rnd1][rnd2] = 0;
        }
    }

    public void display(){
        for (int i = 0; i < 9; i++) {
            System.out.print('\n');
            if(i % 3 == 0 && i != 0) {
                System.out.println(" ----------------------");
            }
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j]);
                if(j % 3 == 2 && j != 8) {
                    System.out.print(" |");
                }
            }
        }
        System.out.print("\n");
    }

    public int[][] getBoard(){
        return board;
    }
}
