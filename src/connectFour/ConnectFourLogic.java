package connectFour;

public class ConnectFourLogic {

    public static void initializeGrid(Grid board) {
        int row = board.getRow();
        int col = board.getCol();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board.setCell(i, j, Enum.EMPTY.toString());
            }
        }

    }

    // Insert player's disk in the appropriate column
    // return true if it's possible
    // otherwise return false
    public static Boolean InsertPlayerDisk(Grid board, int inputCol, Player player) {
        if (!validatePlayerInput(inputCol)) return false;

        for (int i = 5; i >= 0; i--) {
            if (board.getCell(i, inputCol).equals("EMPTY")) {
                board.setCell(i, inputCol, player.getPlayerColor());
                board.setOccupiedCellNumber();
                return true;
            }
        }
        return false;
    }

    private static Boolean validatePlayerInput(int inputCol) {
        return 0 <= inputCol && inputCol <= 6;
    }

    public static Boolean isWinner(Grid board, Player player) {
        return checkFourVertical(board, player) ||
                checkFourHorizontal(board, player) ||
                checkFourDownwardDiagonal(board, player) ||
                checkFourUpwardDiagonal(board, player);
    }

    private static Boolean checkFourVertical(Grid board, Player player) {
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j <= 3; j++) {
                if (board.getCell(i, j).equals(player.getPlayerColor()) &&
                        board.getCell(i, j + 1).equals(player.getPlayerColor()) &&
                        board.getCell(i, j + 2).equals(player.getPlayerColor()) &&
                        board.getCell(i, j + 3).equals(player.getPlayerColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean checkFourHorizontal(Grid board, Player player) {
        for (int j = 0; j < board.getCol(); j++) {
            for (int i = 0; i <= 2; i++) {
                if (board.getCell(i, j).equals(player.getPlayerColor()) &&
                        board.getCell(i + 1, j).equals(player.getPlayerColor()) &&
                        board.getCell(i + 2, j).equals(player.getPlayerColor()) &&
                        board.getCell(i + 3, j).equals(player.getPlayerColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean checkFourDownwardDiagonal(Grid board, Player player) {
        for (int i = 0; i < board.getRow() - 3; i++) {
            for (int j = 0; j < board.getCol() - 3; j++) {
                if (board.getCell(i, j).equals(player.getPlayerColor()) &&
                        board.getCell(i + 1, j + 1).equals(player.getPlayerColor()) &&
                        board.getCell(i + 2, j + 2).equals(player.getPlayerColor()) &&
                        board.getCell(i + 3, j + 3).equals(player.getPlayerColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean checkFourUpwardDiagonal(Grid board, Player player) {
        for (int i = 0; i < board.getRow() - 3; i++) {
            for (int j = board.getCol() - 1; j > 2; j--) {
                if (board.getCell(i, j).equals(player.getPlayerColor()) &&
                        board.getCell(i + 1, j - 1).equals(player.getPlayerColor()) &&
                        board.getCell(i + 2, j - 2).equals(player.getPlayerColor()) &&
                        board.getCell(i + 3, j - 3).equals(player.getPlayerColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean isTie(Grid board) {
        return board.getOccupiedCellNumber() == 42;
    }
}
