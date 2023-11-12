package formativetask1;

public class GameManagement {

    private int gameEndValue = 200;
    private char forfeitCharacter = '*';
    public boolean forfeit = false;
    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    private Turn whoseTurn;

    public boolean isGameOver() {
        return playerOneScore > gameEndValue || playerTwoScore > gameEndValue || forfeit == true;
    }

    public void addToPlayerScore(int score) {
        System.out.println("player: " + getCurrentTurn());
        if (whoseTurn == Turn.playerOne) {
            playerOneScore += score;
        } else {
            playerTwoScore += score;
        }
    }

    public enum Turn {
        playerOne,
        playerTwo
    }

    public GameManagement() {
        // setting the initial turn to playerTwo
        this.whoseTurn = Turn.playerOne;
    }

    public Turn getCurrentTurn() {
        // method to return the turn
        return whoseTurn;
    }

    public void changeTurn() {
        //if statement to change turn
        if (whoseTurn == Turn.playerOne) {
            whoseTurn = Turn.playerTwo;
        } else {
            whoseTurn = Turn.playerOne;
        }
    }

    public boolean forfeitGame(String word) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == forfeitCharacter) {
                return true;
            }
        }
        return false;

    }

}
