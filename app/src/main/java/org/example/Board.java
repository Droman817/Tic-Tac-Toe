public class Board {

    private char[] cells;

    public Board() {
        cells = new char[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = Character.forDigit(i + 1, 10);
        }
    }

    public boolean makeMove(int position, char player) {
        if (position < 1 || position > 9) {
            return false;
        }

        if (cells[position - 1] == 'X' || cells[position - 1] == 'O') {
            return false;
        }

        cells[position - 1] = player;
        return true;
    }

    public boolean checkWin() {
        int[][] winPositions = {
                {0,1,2}, {3,4,5}, {6,7,8}, // rows
                {0,3,6}, {1,4,7}, {2,5,8}, // columns
                {0,4,8}, {2,4,6}           // diagonals
        };

        for (int[] combo : winPositions) {
            if (cells[combo[0]] == cells[combo[1]] &&
                cells[combo[1]] == cells[combo[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char cell : cells) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println();
        System.out.println("  " + cells[0] + "  |  " + cells[1] + "  |  " + cells[2]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + cells[3] + "  |  " + cells[4] + "  |  " + cells[5]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + cells[6] + "  |  " + cells[7] + "  |  " + cells[8]);
        System.out.println();
    }
}