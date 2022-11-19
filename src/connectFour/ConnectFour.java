package connectFour;

import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        welcomeMessage();

        // Initialize Players
        Player activePlayer = createPlayer("Player 1", Enum.YELLOW);
        Player opponent = createPlayer("Player 2", Enum.RED);
        Player winner = null;

        // Initialize Board
        Grid board = new Grid();
        ConnectFourLogic.initializeGrid(board);

        while (winner == null) {
            // Display the game board
            displayGrid(board);

            RecordPlayerDisk(board, activePlayer);

            // Check if the game is over
            if (ConnectFourLogic.isWinner(board, activePlayer)) {
                winner = activePlayer;
                break;
            } else {
                // Check if the game is tie
                if (ConnectFourLogic.isTie(board)) break;

                // Set the opponent to active player
                Player tmp = activePlayer;
                activePlayer = opponent;
                opponent = tmp;
            }
        }

        System.out.println(resultMessage(winner));
        displayGrid(board);
    }

    public static void welcomeMessage() {
        System.out.println("----Connect 4----");
        System.out.println("-Created by JHP-");
        System.out.println();
    }

    public static Player createPlayer(String playerNumber, Enum playerColor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your " + playerNumber + "'s name: ");
        String playerName = sc.nextLine();

        return new Player(playerName, playerColor);
    }

    public static void displayGrid(Grid board) {
        for (int i = 0; i < board.getCol(); i ++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getCol(); j++) {
                System.out.print("|");
                if (board.getCell(i, j).equals("EMPTY")) {
                    System.out.print(" ");
                } else if (board.getCell(i, j).equals("RED")) {
                    System.out.print("R");
                } else if (board.getCell(i, j).equals("YELLOW")) {
                    System.out.print("Y");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void RecordPlayerDisk(Grid board, Player activePlayer) {
        while (true) {
            System.out.println(activePlayer.getName() + "'s turn (" + activePlayer.getPlayerColor() + ")");
            int inputCol = AskForInput();

            Boolean isValidInput = ConnectFourLogic.InsertPlayerDisk(board, inputCol, activePlayer);

            if (isValidInput) break;

            System.out.println("Invalid input. Try again");
        }
    }

    private static int AskForInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose column (0-6):");
        return Integer.parseInt(sc.nextLine());
    }

    private static String resultMessage(Player winner) {
        if (winner == null) {
            return "=== Tie game ===";
        } else {
            return "=== Winner: " + winner.getName() + " ===";
        }
    }
}
