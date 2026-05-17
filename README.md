# Tic-Tac-Toe
Tic Tac Toe

Description

This is a console-based Tic Tac Toe game for two players (X and O). Players take turns entering a number (1–9) to place their mark on the board. The game tracks wins, losses, and ties across multiple rounds.
How to Play
	•	The board is numbered 1–9
	•	Players take turns choosing a number
	•	The first player to get 3 in a row wins
	•	If the board fills with no winner, it is a tie

Features
	•	Two-player gameplay (X and O)
	•	Win detection (rows, columns, diagonals)
	•	Tie detection
	•	Game log tracking wins and ties
	•	Displays score after each round
	•	Loser goes first in the next game
	•	Saves final game log to a file when exiting

Input Rules
	•	Enter numbers 1–9 only
	•	Cannot choose already taken spots
	•	Invalid input will prompt you to try again (no crashes)

Output File

When the game ends, a file called game.txt is created. It contains:
	•	Player X wins
	•	Player O wins
	•	Number of ties