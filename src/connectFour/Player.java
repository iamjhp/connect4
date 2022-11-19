package connectFour;

public class Player {
    private String playerName;
    private String playerColor;

    public Player(String playerName, Enum playerNumber) {
        this.playerName = playerName;
        this.playerColor = playerNumber.name();
    }

    public String getName() {
        return this.playerName;
    }

    public String getPlayerColor() {
        return this.playerColor;
    }
}
