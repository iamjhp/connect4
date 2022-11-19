package connectFour;

public class Grid {
    private final int row = 6;
    private final int col = 7;
    private int occupiedCell;
    private String[][] board;

    public Grid() {
        this.board = new String[row][col];
        this.occupiedCell = 0;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public String getCell(int row, int col) {
        return this.board[row][col];
    }

    public void setCell(int row, int col, String value) {
        this.board[row][col] = value;
    }

    public int getOccupiedCellNumber() {
        return this.occupiedCell;
    }

    public void setOccupiedCellNumber() {
        this.occupiedCell++;
    }
}
