import java.io.FileWriter;
import java.io.IOException;

public class GameLog {
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    // Add a win for a player
    public void addWin(String player) {
        if (player.equalsIgnoreCase("X")) xWins++;
        else if (player.equalsIgnoreCase("O")) oWins++;
    }

    // Add a tie
    public void addTie() {
        ties++;
    }

    // Print the current game log to the console
    public void printLog() {
        System.out.println("\nThe current log is:\n");
        System.out.printf("Player X Wins   %d%n", xWins);
        System.out.printf("Player O Wins   %d%n", oWins);
        System.out.printf("Ties            %d%n", ties);
    }

    // Save the game log to disk as game.txt
    public void saveToFile() {
        try (FileWriter writer = new FileWriter("game.txt")) {
            writer.write("Final Game Log:\n");
            writer.write(String.format("Player X Wins   %d%n", xWins));
            writer.write(String.format("Player O Wins   %d%n", oWins));
            writer.write(String.format("Ties            %d%n", ties));
            System.out.println("\nGame log written to game.txt!");
        } catch (IOException e) {
            System.out.println("Error writing game log to file: " + e.getMessage());
        }
    }
}