package org.example;
import java.io.FileWriter;
import java.io.IOException;

public class GameLog {
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    public void recordWin(String player) {
        if (player.equals("X")) xWins++;
        else if (player.equals("O")) oWins++;
    }

    public void recordTie() {
        ties++;
    }

    public void printLog() {
        System.out.println("\nThe current log is:\n");
        System.out.printf("Player X Wins   %d%n", xWins);
        System.out.printf("Player O Wins   %d%n", oWins);
        System.out.printf("Ties            %d%n", ties);
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("game.txt")) {
            writer.write("Final Game Log:\n\n");
            writer.write("Player X Wins   " + xWins + "\n");
            writer.write("Player O Wins   " + oWins + "\n");
            writer.write("Ties            " + ties + "\n");
            System.out.println("\nGame log saved to game.txt");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}