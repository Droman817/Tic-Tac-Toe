import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (playAgain) {

            Board board = new Board();
            char currentPlayer = 'X';
            boolean gameOver = false;

            board.printBoard();

            while (!gameOver) {

                System.out.print("What is your move? ");
                String input = scanner.nextLine().trim();

                int position;

                try {
                    position = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("That is not a valid move! Try again.");
                    continue;
                }

                if (!board.makeMove(position, currentPlayer)) {
                    System.out.println("That is not a valid move! Try again.");
                    continue;
                }

                board.printBoard();

                if (board.checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (board.isDraw()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            boolean validAnswer = false;

            while (!validAnswer) {
                System.out.print("Would you like to play again (yes/no)? ");
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("yes")) {
                    validAnswer = true;
                } else if (answer.equals("no")) {
                    validAnswer = true;
                    playAgain = false;
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("That is not a valid entry!");
                }
            }
        }

        scanner.close();
    }
}