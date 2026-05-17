package org.example;

public class Board {

    private String[] board = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
    };

    public void display() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public boolean isValidMove(int move) {
        return move >= 1 && move <= 9 &&
                !board[move - 1].equals("X") &&
                !board[move - 1].equals("O");
    }

    public void makeMove(int move, String player) {
        board[move - 1] = player;
    }

    public void undoMove(int move) {
        board[move - 1] = String.valueOf(move);
    }

    public boolean checkWinner() {

        int[][] combos = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] combo : combos) {

            if (board[combo[0]].equals(board[combo[1]]) &&
                    board[combo[1]].equals(board[combo[2]])) {

                return true;
            }
        }

        return false;
    }

    public boolean isFull() {

        for (String spot : board) {

            if (!spot.equals("X") && !spot.equals("O")) {
                return false;
            }
        }

        return true;
    }

    public boolean isEmpty() {

        for (String spot : board) {

            if (spot.equals("X") || spot.equals("O")) {
                return false;
            }
        }

        return true;
    }

    public int moveCount() {

        int count = 0;

        for (String spot : board) {

            if (spot.equals("X") || spot.equals("O")) {
                count++;
            }
        }

        return count;
    }
}