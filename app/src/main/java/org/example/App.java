package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameLog log = new GameLog();

        boolean playAgain = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (playAgain) {

            System.out.println();
            System.out.println("What kind of game would you like to play?");
            System.out.println();
            System.out.println("1. Human vs. Human");
            System.out.println("2. Human vs. Computer");
            System.out.println("3. Computer vs. Human");
            System.out.println();

            int selection = getMenuChoice(scanner);

            Board board = new Board();

            ComputerPlayer computer = new ComputerPlayer();

            String currentPlayer = "X";

            boolean vsComputer = selection == 2 || selection == 3;

            String computerPlayer = selection == 3 ? "X" : "O";

            while (true) {

                board.display();

                int move;

                if (vsComputer && currentPlayer.equals(computerPlayer)) {

                    move = computer.getMove(
                            board,
                            computerPlayer,
                            computerPlayer.equals("X") ? "O" : "X"
                    );

                    System.out.println("Computer chooses " + move);

                } else {

                    move = getValidMove(scanner, board);
                }

                board.makeMove(move, currentPlayer);

                if (board.checkWinner()) {

                    board.display();

                    System.out.println("Player " + currentPlayer + " wins!");

                    log.recordWin(currentPlayer);

                    break;
                }

                if (board.isFull()) {

                    board.display();

                    System.out.println("It's a tie!");

                    log.recordTie();

                    break;
                }

                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }

            log.printLog();

            System.out.print("Would you like to play again (yes/no)? ");

            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        log.saveToFile();

        scanner.close();

        System.out.println("Goodbye!");
    }

    private static int getMenuChoice(Scanner scanner) {

        while (true) {

            System.out.print("What is your selection? ");

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 3) {
                    return choice;
                }

            } catch (Exception e) {

            }

            System.out.println("Invalid selection.");
        }
    }

    private static int getValidMove(Scanner scanner, Board board) {

        while (true) {

            System.out.print("What is your move? ");

            try {

                int move = Integer.parseInt(scanner.nextLine());

                if (board.isValidMove(move)) {
                    return move;
                }

            } catch (Exception e) {

            }

            System.out.println("That is not a valid move! Try again.");
        }
    }
}