import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLog log = new GameLog();

        String firstPlayer = "X";  // initial turn
        boolean playAgain = true;

        while (playAgain) {
            Board board = new Board(); // or however your board is initialized
            String winner = playGame(scanner, board, firstPlayer);

            if (winner.equals("Tie")) log.addTie();
            else log.addWin(winner);

            log.printLog();

            System.out.print("\nWould you like to play again (yes/no)? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                // swap first player if there was a winner
                if (!winner.equals("Tie")) firstPlayer = winner.equals("X") ? "O" : "X";
                System.out.println("\nGreat! " + firstPlayer + " will go first this time!\n");
            } else {
                playAgain = false;
            }
        }

        log.saveToFile();
        scanner.close();
    }

    // Example playGame method: you might need to adapt this to your existing Board/Game methods
    private static String playGame(Scanner scanner, Board board, String currentPlayer) {
        while (true) {
            board.display(); // display the board

            System.out.print("What is your move? ");
            int move = getValidMove(scanner, board);

            board.makeMove(move, currentPlayer);

            if (board.checkWinner()) {
                board.display();
                System.out.println("\nPlayer " + currentPlayer + " wins!");
                return currentPlayer;
            }

            if (board.isFull()) {
                board.display();
                System.out.println("\nIt's a tie!");
                return "Tie";
            }

            currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // switch turn
        }
    }

    private static int getValidMove(Scanner scanner, Board board) {
        int move = -1;
        while (true) {
            try {
                move = Integer.parseInt(scanner.nextLine());
                if (board.isValidMove(move)) break;
                else System.out.print("Invalid move. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number between 1-9: ");
            }
        }
        return move;
    }
}