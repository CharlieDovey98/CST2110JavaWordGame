package formativetask1;

public class GameManager {

    private int gameEndValue = 200;
    private char forfeitCharacter = '*';
    private int gameScore = 0;
    private Turn whoseTurn;

    public char playerOneInitialwordLastChar = 'a';
    public boolean playerOneInitalWord = false;
    public boolean playerTwoInitalWord = false;
    public boolean forfeit = false;

    public boolean isGameOver() {
        return gameScore > gameEndValue || forfeit == true;
    }

    public void addToGameScore(int score) {
        gameScore += score;
    }

    public int checkGameScore() {
        return gameScore;
    }

    public enum Turn {
        playerOne,
        playerTwo
    }

    public GameManager() {
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

    public boolean startingWordCharacter(String firstWord, char playerOneInitialwordLastChar) {
        return (playerOneInitialwordLastChar == firstWord.charAt(0));

    }

}
