package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer {

    private Random random = new Random();

    public int getMove(Board board, String computer, String human) {

        if (board.isEmpty()) {
            int[] corners = {1, 3, 7, 9};
            return corners[random.nextInt(corners.length)];
        }

        if (board.moveCount() == 1 && board.isValidMove(5)) {
            return 5;
        }

        for (int i = 1; i <= 9; i++) {
            if (board.isValidMove(i)) {
                board.makeMove(i, computer);

                if (board.checkWinner()) {
                    board.undoMove(i);
                    return i;
                }

                board.undoMove(i);
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (board.isValidMove(i)) {
                board.makeMove(i, human);

                if (board.checkWinner()) {
                    board.undoMove(i);
                    return i;
                }

                board.undoMove(i);
            }
        }

        ArrayList<Integer> moves = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (board.isValidMove(i)) {
                moves.add(i);
            }
        }

        return moves.get(random.nextInt(moves.size()));
    }
}